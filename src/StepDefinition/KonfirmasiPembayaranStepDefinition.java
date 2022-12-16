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

public class KonfirmasiPembayaranStepDefinition {

    public static WebDriver driver;

    GlobalUtils utils = new GlobalUtils();

    @Given("user navigate to application URL Confirmation Payment")
    public void userNavigateToApplicationURLConfirmationPayment() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://blossomzones.com/konfirmasi-pembayaran/");
        String title = driver.findElement(By.xpath("//h1[contains(text(),'Konfirmasi Pembayaran')]")).getText();
    }

    @When("user input name {string} email {string} no transaksi {string} jumlah transfer {string}")
    public void userInputNameEmailNoTransaksiJumlahTransfer(String name, String email, String no_transaksi, String jumlah_transfer) {
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[2]/span/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[2]/span/input")).sendKeys(name);

        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[5]/span/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[5]/span/input")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[8]/span/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[8]/span/input")).sendKeys(no_transaksi);

        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[12]/span/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[12]/span/input")).sendKeys(jumlah_transfer);
    }

    @And("user click on submit button transaction")
    public void userClickOnSubmitButtonTransaction() {
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/p[14]/input")).click();
    }

    @Then("confirmation payment created")
    public void confirmationPaymentCreated() {
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f3296-p3297-o1\"]/form/div[2]")).getText();
        //driver.quit();
    }
}
