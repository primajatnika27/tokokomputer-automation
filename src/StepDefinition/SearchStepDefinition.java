package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.GlobalUtils;

import java.util.concurrent.TimeUnit;

public class SearchStepDefinition {
    public static WebDriver driver;

    @Given("user navigate to application URL")
    public void I_navigate_to_application_URL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/");

    }

    @When("input a product {string}")
    public void inputAProduct(String product_name) {
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).clear();
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).sendKeys(product_name);
    }

    @And("click button search")
    public void clickButtonSearch() throws Throwable {
        driver.findElement(By.xpath("//body/div[@id='page']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).click();
        Thread.sleep(3000);
    }

    @Then("display search {string}")
    public void displaySearch(String expectedResult) {
        String actualResult = null;

        GlobalUtils utils = new GlobalUtils();

        System.out.println(utils.isElementPresent(driver, By.xpath("//p[contains(text(),'Nothing Found! Please refine your search and try again.')]")));

        if (utils.isElementPresent(driver, By.xpath("//p[contains(text(),'Nothing Found! Please refine your search and try again.')]"))) {
            actualResult = "Nothing Found! Please refine your search and try again.";
            Assert.assertEquals(expectedResult, actualResult);
        } else {
            actualResult = "Success search item";
            Assert.assertEquals(expectedResult, actualResult);
        }

        driver.quit();
    }
}
