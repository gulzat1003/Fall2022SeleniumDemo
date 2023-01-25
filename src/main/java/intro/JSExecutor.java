package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest {

    @Test
    public void test(){
  //      browserHelper.openURL("https://www.etsy.com/");
        browserHelper.openURL("https://demoqa.com/dynamic-properties");

        WebElement clickButton = driver.findElement(By.xpath("//button[@id='enableAfter']"));
//        clickButton.click();
        Helper.waitForElementClickable(driver, clickButton);


//        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
//        Helper.jsClick(driver, careersLink);
//        Helper.pause(10000);
//
//        Helper.jsScrollDownThePage(driver, "350");
//        Helper.pause(3000);
//        Helper.jsScrollDownThePage(driver, "500");
//        Helper.pause(5000);

//        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
//        signInBtn.click();
//        Helper.waitForElementToBeDisplayed(driver, signInBtn);
//        Helper.pause(10000);

//        WebElement inputFieldUser = driver.findElement(By.id("join_neu_email_field"));
//        inputFieldUser.sendKeys("randomUser@gmail.com");
//        Helper.waitForElementToBeDisplayed(driver, inputFieldUser);
//        Helper.pause(5000);




//       Helper.scrollElementIntoView(By.xpath(".//span[contains(text(),'Политики')]"));
//        Helper.pause(3000);






    }


}
