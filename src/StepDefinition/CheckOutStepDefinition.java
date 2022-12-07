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

public class CheckOutStepDefinition {

    public static WebDriver driver;
    GlobalUtils utils = new GlobalUtils();

    @Given("user navigate to application URL chart")
    public void I_navigate_to_application_URL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/");

    }

    @And("user search any item {string}")
    public void userSearchAnyItem(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).clear();
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).sendKeys(arg0);

        driver.findElement(By.xpath("//body/div[@id='page']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).click();
        Thread.sleep(3000);
    }

    @When("user add item to chart")
    public void userAddItemToChart() throws Throwable {
        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[2]/main[1]/article[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[2]")).click();
        Thread.sleep(3000);
    }

    @And("user view item cart")
    public void userViewItemCart() throws Throwable {
        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[2]/main[1]/article[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[3]")).click();
        Thread.sleep(3000);
    }

    @Then("display item on cart {string}")
    public void displayItemOnCart(String arg0) {
        String actualResult = null;

        if (utils.isElementPresent(driver, By.xpath("//h1[contains(text(),'Cart')]"))) {
            actualResult = "Success add to Chart";
            Assert.assertEquals(arg0, actualResult);
        }
    }

    @Given("user process to check out")
    public void userProcessToCheckOut() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
        Thread.sleep(2000);
    }

    @Then("display checkout page {string}")
    public void displayCheckoutPage(String expected) {
        String actualResult = null;

        if (utils.isElementPresent(driver, By.xpath("//h1[contains(text(),'Checkout')]"))) {
            actualResult = "Success show shipping page";
            Assert.assertEquals(expected, actualResult);
        }

        driver.quit();
    }
}
