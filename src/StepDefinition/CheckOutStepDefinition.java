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

        //driver.quit();
    }

    @Given("user fill the billing & shipping data {string} {string} {string}{string}{string}{string} {string} {string} {string} {string}")
    public void userFillTheBillingShippingData(String firstName, String lastName, String billingAddress,String state,String city,String district, String postalCode, String phone, String email, String notes) throws Throwable {
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//textarea[@id='billing_address_1']")).sendKeys(billingAddress);
        driver.findElement(By.id("select2-billing_state-container")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li["+state+"]")).click();
        Thread.sleep(200);
        driver.findElement(By.id("select2-billing_indo_ongkir_kota-container")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li["+city+"]")).click();
        Thread.sleep(200);
        driver.findElement(By.id("select2-billing_indo_ongkir_kecamatan-container")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li["+district+"]")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(postalCode);
        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys(notes);
        Thread.sleep(3000);
    }


    @When("user place order the check out data")
    public void userPlaceOrderTheCheckOutData() {
        driver.findElement(By.xpath("//button[@id='place_order']")).click();
    }

    @Then("display order received page {string}")
    public void displayOrderReceivedPage(String expected) {

        driver.findElement(By.xpath("//p[contains(text(),'Thank you. Your order has been received.')]")).isDisplayed();
        String empty = driver.findElement(By.xpath("//p[contains(text(),'Thank you. Your order has been received.')]")).getText();
        if (empty.contains("Your cart is currently empty.")) {
            Assert.assertEquals(expected, empty);
        } else {
            Assert.assertFalse(true);
        }
        driver.quit();
    }


}

