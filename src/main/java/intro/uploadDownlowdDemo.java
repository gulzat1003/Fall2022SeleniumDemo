package intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class uploadDownlowdDemo extends BaseTest{

    @Test
    public  void test1(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\fakepath\\sampleFile.jpeg");

    }
}
