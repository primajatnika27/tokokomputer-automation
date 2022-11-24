package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterStepDefinition {
    WebDriver driver;

    @And("user open Register Page")
    public void userNavigateToRegisterPage() {
//        driver.findElement(By.xpath(" //a[contains(text(),'Login / Register')]")).click();
        driver.findElement(By.linkText(" Login / Register")).click();
//        driver.findElement(By.xpath(" //a[contains(text(),'Register')]")).click();
    }

    @When("user register account using Username {string} and Email {string}")
    public void userRegisterAccountUsingUsernameAndEmail(String username, String email) {
        driver.findElement(By.xpath("//input[@id='user_login']")).clear();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='user_email']")).clear();
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);
    }

    @And("user click on Register button")
    public void userClickOnRegisterButton() {
        driver.findElement(By.xpath("  //input[@id='wp-submit']")).click();
    }

    @Then("Customer got new account")
    public void customerGotNewAccount() {
//        //		Alert alert = driver.switchTo().alert();
//        String title = driver.getTitle();
//        System.out.println(title);
//        String actualResult = null;
//
//        if (title.contains("Your store. Login")) {
//            actualResult = "success";
//        } else {
//            actualResult = "failure";
//        }
////
////        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
