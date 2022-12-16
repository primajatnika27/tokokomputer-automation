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
    public void userInputNameEmailTitleTestimonial(String name, String email, String title, String testimoni) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[1]")).clear();
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[1]")).sendKeys(name);

        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[2]")).clear();
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[2]")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[3]")).clear();
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/input[3]")).sendKeys(title);

        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/textarea")).clear();
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/textarea")).sendKeys(testimoni);

//        String captcha = driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/div/img")).getText();
//        System.out.println("ini captcha");
//        System.out.println(captcha);
        Thread.sleep(300);
    }

    @And("user click on submit button")
    public void userClickOnSubmitButton() {
        driver.findElement(By.xpath("//*[@id=\"post-1060\"]/div/div[1]/form/span[2]/input[2]")).click();
    }

    @Then("testimonial created")
    public void testimonialCreated() {
        driver.quit();
    }
}
