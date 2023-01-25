package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MovingChynaraDelivery extends BaseTest1{
    @Test
    public void test() {
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement houseMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeMenu);
        select2.selectByVisibleText("Just a few Items");
        Helper.pause(3000);

        WebElement clickQuotes = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        clickQuotes.click();
        Helper.pause(1000);

        WebElement continuesBox = driver.findElement(By.xpath("//span[@class='col-sm-9 col-xs-12']"));
        continuesBox.click();
        Helper.pause(1000);

        driver.findElement(By.xpath("//div[@class='modal-buttons']/a")).click();
        Helper.pause(1000);
        driver.findElement(By.id("closeTutorial")).click();

        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(1000);


        WebElement plusBoxDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
        action.doubleClick(plusBoxDresser).perform();
        Helper.pause(1000);

        WebElement bedImageContainer = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(bedImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(1000);

        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(1000);


        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement sofaImageContainer = driver.findElement(By.xpath("//div[@class='10']//figure"));
        action.moveToElement(sofaImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='10']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(1000);
        WebElement plusBoxSofa = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[9]"));
        action.doubleClick(plusBoxSofa).perform();

        WebElement mirrorImageContainer = driver.findElement(By.xpath("//div[@class='7']//figure"));
        action.moveToElement(mirrorImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='7']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        action.doubleClick(mirrorImageContainer).perform();

        WebElement complete = driver.findElement(By.xpath("//h3[text()='Complete Order']"));
        complete.click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[2]")).click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]")).click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[8]")).click();


       driver.findElement(By.xpath("(//a[@class='btn btn-blue'])[3]")).click();

        Helper.pause(3000);
        WebElement restrictions = driver.findElement(By.xpath("((//button[@class='btn btn-blue open-instructions'])[1]"));
        restrictions.click();
       // driver.findElement(By.id("instraction_btn_505")).click();






//        WebElement kitchenContainer = driver.findElement(By.xpath("(//div[@class='quantity-module hidden-xs hidden-sm'])[4]"));
//        action.moveToElement(kitchenContainer).build().perform();
//        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[7]"));
//        Helper.pause(3000);

    }
}
