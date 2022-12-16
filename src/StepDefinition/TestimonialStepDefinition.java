package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.GlobalUtils;

import java.util.concurrent.TimeUnit;

public class TestimonialStepDefinition {

    public static WebDriver driver;

    GlobalUtils utils = new GlobalUtils();

    @Given("user navigate to application URL testimonial")
    public void userNavigateToApplicationURLTestimonial() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/testimonials/");
    }

    @When("user input name {string} email {string} title {string} testimonial {string}")
    public void userInputNameEmailTitleTestimonial(String arg0, String arg1, String arg2, String arg3) {
        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/input[1]")).clear();
        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/input[1]")).sendKeys(arg0);

        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/input[2]']")).clear();
        driver.findElement(By.xpath(" //[@id=\"post-1060\"]/div/div[1]/form/input[2]")).sendKeys(arg1);

        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/input[3]")).clear();
        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/input[3]")).sendKeys(arg2);

        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/textarea")).clear();
        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/textarea")).sendKeys(arg3);
    }

    @And("user click on submit button")
    public void userClickOnSubmitButton() {
        driver.findElement(By.xpath("//[@id=\"post-1060\"]/div/div[1]/form/span[2]/input[2]")).click();
    }

    @Then("testimonial created")
    public void testimonialCreated() {
        driver.quit();
    }
}
