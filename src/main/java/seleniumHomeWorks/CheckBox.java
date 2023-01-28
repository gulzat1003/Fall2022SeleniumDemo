package seleniumHomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox extends BaseTest1 {

    @Test
    public void checkBoxTest(){
        browserHelper.openURL(" https://itera-qa.azurewebsites.net/home/automation");
//        driver.findElement(By.id("tuesday")).click();
//        driver.findElement(By.id("friday")).click();
                                                                                                     // endWith
        List<WebElement> days = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        int size = days.size();
        for (int i = 0; i < size; i++) {
            days.get(i).click();
        }
        WebElement selectCountry = driver.findElement(By.xpath("//select[@class='custom-select']"));
        selectCountry.click();
        Select select = new Select(selectCountry);
        select.selectByVisibleText("Greece");


    }


}
