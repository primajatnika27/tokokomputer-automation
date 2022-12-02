package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CheckoutStepDefinition {

    WebDriver driver;

    @And("user add item to cart")
    public void userAddItemToCart() {
        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[2]/div[1]/main[1]/div[1]/div[2]/div[3]/div[1]/div[1]/ul[1]/li[1]/a[2]")).click();
    }

    @When("user view item cart")
    public void userViewItemCart() {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /// After 10 second, prepare load this element
        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[2]/div[1]/main[1]/div[1]/div[2]/div[3]/div[1]/div[1]/ul[1]/li[1]/a[3]")).click();
    }

    @Then("display item on cart {expected}")
    public void displayItemOnCart(String expected) {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//h1[contains(text(),'Cart')]")).isDisplayed();
        String empty = driver.findElement(By.xpath("//p[contains(text(),'Your cart is currently empty.')]")).getText();
        if (empty.contains("Your cart is currently empty.")) {
            Assert.assertEquals(expected, empty);
        } else {
            Assert.assertFalse(true);
        }
        driver.quit();
    }

    @When("user process to check out")
    public void userProcessToCheckOut() {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
    }

    @Then("display checkout page")
    public void displayCheckoutPage() {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//h3[contains(text(),'Billing & Shipping')]")).isDisplayed();
    }


    @And("user fill the billing & shipping data {firstName} {lastName} {address} {postalCode} {phone} {email} {notes}")
    public void userFillTheBillingShippingData(String firstName, String lastName, String billingAddress, String postalCode,String phone, String email, String notes) {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//textarea[@id='billing_address_1']")).sendKeys(billingAddress);
        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(postalCode);
        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys(notes);
    }

    @When("user place order the check out data")
    public void userPlaceOrderTheCheckOutData() {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='place_order']")).click();
    }

    @Then("display order received page")
    public void displayOrderReceivedPage(String expected) {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
