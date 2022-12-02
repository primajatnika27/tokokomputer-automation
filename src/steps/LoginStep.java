package steps;

import dto.LoginDto;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TypeUtils;


@AllArgsConstructor
public class LoginStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStep.class);

    private LoginDto loginDto;

    private WebElement element;

    public void login(String username, String password) throws InterruptedException {
        LOGGER.debug("login in website ussing username {} and password {}", username, password);
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        TypeUtils.findElement(element, By.xpath("//input[@id='Email']"));
        TypeUtils.findElement(element, By.xpath("//input[@id='Email']"));

        TypeUtils.sendKeys(element, loginDto.getUsername());
        TypeUtils.sendKeys(element, loginDto.getPassword());
    }
}
