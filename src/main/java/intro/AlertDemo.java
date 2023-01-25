package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{
    @Test
    public void alertTest(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(3000);

    }

    @Test
    public void testExplicitWaitAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test

    public void thirdButton(){
        driver.get("https://demoqa.com/alerts");
        WebElement thirdButton = driver.findElement(By.id("confirmButton"));
        thirdButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement cancelText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(cancelText.getText(), "You selected Cancel");

    }
    @Test
    public void testTextEnterAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement textEnter = driver.findElement(By.id("promtButton"));
        textEnter.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Gulzat");
        alert.accept();

        WebElement textTest = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(textTest.getText(), "You entered Gulzat");
    }

    @Test
    public void testAlertPractice(){
        browserHelper.openURL("https://demoqa.com/alerts");
        WebElement buttonAlert = driver.findElement(By.linkText("Click me"));
        buttonAlert.click();
        driver.findElement(By.xpath("//button[contains(text(),'Click me')]"));
        driver.findElement(By.className("btn btn-primary"));

    }
}
