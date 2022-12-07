package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.GlobalUtils;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinition {

    public static WebDriver driver;

    GlobalUtils utils = new GlobalUtils();

    @Given("user navigate to check login page")
    public void userNavigateToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/wp-login.php");
    }

    @When("I enter Username as {string} and Password as {string} into the field")
    public void I_enter_Username_as_someusername_and_Password_as_somepassword_into_the_field(String username, String password) throws Throwable {

        System.out.println(username);
        System.out.println(password);

        driver.findElement(By.xpath("//input[@id='user_login']")).clear();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='user_pass']")).clear();
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
        Thread.sleep(3000);
    }

    @And("^I click on Login button$")
    public void I_click_on_Login_button() {
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
    }

    @Then("User should be able to login based on {string} login status")
    public void User_should_be_able_to_login_based_on_expected_login_status(String expectedResult) {

        String actualResult = null;

        if (utils.isElementPresent(driver, By.xpath("//div[@id='login_error']"))) {
            String errorLogin = driver.findElement(By.xpath("//div[@id='login_error']")).getText();

            System.out.println(errorLogin);

            if (errorLogin.contains(expectedResult)) {
                actualResult = expectedResult;

                Assert.assertEquals(expectedResult, actualResult);
                driver.quit();
            }
        } else {
            String title = driver.findElement(By.xpath("/html/head/title")).getText();
            System.out.println(title);
            actualResult = title;

            Assert.assertEquals(expectedResult, actualResult);
            driver.quit();
        }
    }
}