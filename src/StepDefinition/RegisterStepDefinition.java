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

public class RegisterStepDefinition {
    public static WebDriver driver;

    GlobalUtils utils = new GlobalUtils();

    @Given("user navigate to application URL register")
    public void I_navigate_to_application_URL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/");

    }

    @And("user open Register Page")
    public void userNavigateToRegisterPage() throws Throwable {
        driver.findElement(By.xpath(" //a[contains(text(),'Login / Register')]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        Thread.sleep(500);
    }

    @When("user register account using Username {string} and Email {string}")
    public void userRegisterAccountUsingUsernameAndEmail(String username, String email) {
        driver.findElement(By.xpath("//input[@id='user_login']")).clear();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='user_email']")).clear();
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);
    }

    @And("user click on Register button")
    public void userClickOnRegisterButton() throws Throwable {
        driver.findElement(By.xpath("  //input[@id='wp-submit']")).click();
        Thread.sleep(1000);
    }

    @Then("Customer got new account")
    public void customerGotNewAccount() {
        driver.quit();
    }
}
