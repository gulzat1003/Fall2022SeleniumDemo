package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Helper {
    private static JavascriptExecutor js;
    private static WebDriver driver;
    private static WebElement element;

    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // 1. static ExpectedCondition < WebElement > elementToBeClickable(By locator)
    //This condition is used to instruct a command to wait until the element is clickable by the locator.mn bvc
    public static void jsClick(WebDriver driver, WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public static void jsScrollDownThePage(WebDriver driver, String pixels) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")", "");
    }

    public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element)).click();
    }

    public static void scrollElementIntoView(By locator) {
//        driver.findElement(locator);
//        js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", element);

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static void waitForElementText(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBe(locator, text));
    }

    public static void hoverOverElement(By locator) {
        driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void sendDates () {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }


}
