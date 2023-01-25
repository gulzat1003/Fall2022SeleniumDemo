package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GovKgHomeWork extends BaseTest1{
    @Test

    public void govKgTest(){

        driver.get("https://dribbble.com/#");
        WebElement dribblePage = driver.findElement(By.xpath("//span[@class='btn-dropdown btn-dropdown-neue open']"));
        dribblePage.click();
        Select select = new Select(dribblePage);
        select.selectByVisibleText("marketplace");
        Helper.pause(2000);

        driver.findElement(By.xpath(".//a[@class='form-btn bg-green']")).click();



    }

}
