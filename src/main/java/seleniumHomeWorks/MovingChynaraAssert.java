package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovingChynaraAssert extends BaseTest1{


    @Test
    public void movingTest(){

        driver.get("https://www.imoving.com");
        WebElement HouseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(HouseTypeSelectMenu);
        select.selectByVisibleText("My Apartment");

        Helper.pause(3000);
        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select1 = new Select(moveSizeMenu);
        select1.selectByVisibleText("Just a few Items");

        driver.findElement(By.xpath(".//button[@class='btn btn-white quickQuoteLink']")).click();
        driver.findElement(By.xpath("//span[@class='col-sm-9 col-xs-12']")).click();
        Helper.pause(1000);

        driver.findElement(By.xpath(".//a[text()='GOT IT']")).click();
        Helper.pause(1000);

        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(2000);

        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);

        WebElement plusBoxDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
        action.doubleClick(plusBoxDresser).perform();
        Helper.pause(1000);

        WebElement bedImageContainer = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(bedImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);
        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(3000);
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement expectedItems = driver.findElement(By.xpath("//span[@class='room-counter']"));
        Assert.assertEquals(expectedItems.getText(),"9 items");


       //  I need to ask
       WebElement dresser = driver.findElement(By.xpath("//h3[text()='Dresser']"));
       Assert.assertTrue(dresser.getText().contains("Dresser"));

        WebElement bed = driver.findElement(By.xpath("//h3[text()='Bed (All parts included)']"));
        Assert.assertEquals(bed.getText(), "Bed (All parts included)");

        WebElement tv = driver.findElement(By.xpath("//h3[text()='Tv']"));
        Assert.assertEquals(tv.getText(),"tv");

 }


}
