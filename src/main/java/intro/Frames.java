package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frames extends BaseTest {

    @Test
    public void testCase(){
     driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(2); //with help of index / ID / WebElement
        WebElement text1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text1.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text2.getText());

        driver.switchTo().defaultContent();
        WebElement text3 = driver.findElement(By.xpath("//div[@class='pattern-backgound playgound-header']"));
        System.out.println(text3.getText());
    }
}
