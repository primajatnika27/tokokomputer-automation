package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.LoginStep;

public class TypeUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStep.class);

    public static void findElement(WebElement element, By by) throws InterruptedException {
        try {
            LOGGER.debug("sending key =  {} to element = {}", element);
            element.findElement(by);
        } catch (Exception e) {
            LOGGER.debug("general error on sendkeys! error - ", e);
            Thread.sleep(500);
            element.findElement(by);
        }
    }

    public static void sendKeys(WebElement element, String text) throws InterruptedException {
        try {
            LOGGER.debug("sending key =  {} to element = {}", element, text);
            element.sendKeys(text);
        } catch (Exception e) {
            LOGGER.debug("general error on sendkeys! error - ", e);
            Thread.sleep(500);
            element.sendKeys(text);
        }
    }
}
