package seleniumHomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractice extends BaseTest1 {


    @Test
    public void loginTest() {
        driver.navigate().to("https://login.yahoo.com/?.intl=us");
        driver.findElement(By.name("username")).sendKeys("randome@gmail.com");
        driver.findElement(By.xpath("//*[contains(text(), 'Stay signed')]")).click(); // Java version


        JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("document.getElementById('persistent').click()");  // JS Version
//       Helper.pause(3000);
//        WebElement checkBox = driver.findElement(By.xpath("//input[@id='persistent']"));
//        js.executeScript("arguments[0].click()", checkBox);           // JS version by  WebElement




        // Enter text into a TextBox using JSExecutor in Selenium WebDriver
        driver.get("https://www.facebook.com/");
//        js.executeScript("document.getElementById('email').value = 'abcd@gmail.com' ", "");

        WebElement element = driver.findElement(By.id("email"));
        js.executeScript("arguments[0].value= 'gulzat@gmail.com'", element);
        String text = (String)js.executeScript(" return document.getElementById('email').value"); // we did casting  here
        System.out.println(text);
        driver.quit();




    }



}
