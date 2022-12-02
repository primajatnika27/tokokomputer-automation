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
import steps.LoginStep;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinition {

    WebDriver driver;

    private LoginStep step;

    @When("^I enter Username as {username} and Password as {password} into the field$")
    public void I_enter_Username_as_someusername_and_Password_as_somepassword_into_the_field(String username, String password) throws InterruptedException {
        step.login(username, password);
    }

    @And("^I click on Login button$")
    public void I_click_on_Login_button() {
        driver.findElement(By.xpath(" //button[contains(text(),'Log in')]")).click();
    }

    @Then("User should be able to login based on \"([^\"]*)\" login status")
    public void User_should_be_able_to_login_based_on_expected_login_status(String expectedResult) {

//		Alert alert = driver.switchTo().alert();
        String title = driver.getTitle();
        System.out.println(title);
        String actualResult = null;

        if (title.contains("Your store. Login")) {
            actualResult = "success";
        } else {
            actualResult = "failure";
        }

        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();

    }
}