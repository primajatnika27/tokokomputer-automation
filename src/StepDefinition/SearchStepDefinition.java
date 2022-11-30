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

import java.util.concurrent.TimeUnit;

public class SearchStepDefinition {
    WebDriver driver;

    @When("input a product {string}")
    public void inputAProduct(String product_name) {
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).clear();
        driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).sendKeys(product_name);
    }

    @And("click button search")
    public void clickButtonSearch() {
        driver.findElement(By.cssSelector("body.home.page-template.page-template-template-homepage.page-template-template-homepage-php.page.page-id-126.wp-custom-logo.wp-embed-responsive.theme-storefront.woocommerce-js.storefront-secondary-navigation.storefront-align-wide.left-sidebar.woocommerce-active.storefront-site-logo-active.elementor-default.elementor-kit-22346:nth-child(2) div.hfeed.site:nth-child(1) div.header-widget-region div.col-full div.widget.widget_products_predictive_search:nth-child(1) div.wc_ps_bar:nth-child(2) div.wc_ps_container.wc_ps_sidebar_container:nth-child(3) form.wc_ps_form div.wc_ps_nav_right:nth-child(2) div.wc_ps_nav_submit > input.wc_ps_nav_submit_bt")).click();
    }

    @Then("display search {string}")
    public void displaySearch(String expectedResult) {
        /// Add Timeout for waiting load this element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'Nothing Found! Please refine your search and try a')]")).getText();
        if (expectedResult.contains(actualResult)) {
            actualResult = "Nothing Found! Please refine your search and try again.";
        } else {
            actualResult = "";
        }
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
