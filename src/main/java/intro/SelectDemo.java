package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{

    @Test
    public void select(){
        driver.get("https://demoqa.com/select-menu");
//        driver.switchTo().frame(1);
//       WebElement selectValue = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
//       selectValue.click();

//        selectValue.sendKeys(Keys.ARROW_DOWN);
////        selectValue.sendKeys(Keys.RETURN);
//        selectValue.click();

       WebElement groupAndOption = driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]"));
       groupAndOption.click();
       Helper.pause(2000);

       WebElement test = driver.findElement(By.xpath("//div[@id='withOptGroup']/div/div/div[contains(.,'Group 1, option 1')]"));
       test.click();

        WebElement selectOne = driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[2]"));
        selectOne.click();
        Helper.pause(2000);
    }

}
