package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AidaiHW extends BaseTest1 {
    @Test
    public void checkData() {
        driver.get("https://demoqa.com/webtables");

        AidaiUser aidai = new AidaiUser("Aidai", "Kurmanbekova", "aidai@gmail.com", 24, 3000, "Moscow");
        List<AidaiUser> data = new ArrayList<>();
        data.add(aidai);

        List<WebElement> containerOfData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(aidai.name);
        driver.findElement(By.id("lastName")).sendKeys(aidai.lastName);
        driver.findElement(By.id("userEmail")).sendKeys(aidai.email);
        driver.findElement(By.id("age")).sendKeys(String.valueOf(aidai.age));
        driver.findElement(By.id("salary")).sendKeys(String.valueOf(aidai.salary));
        driver.findElement(By.id("department")).sendKeys(aidai.department);
        driver.findElement(By.id("submit")).click();
        Helper.pause(4000);

        String getAge = driver.findElement(By.xpath("(//div[@class='rt-tr -even'])[2]/div[3]")).getText();

        for (WebElement e : containerOfData) {
            if (e.getText().contains(aidai.name)) {
                Assert.assertTrue(e.getText().contains(aidai.name));
            }

            int n = Integer.parseInt(getAge);
            if (Integer.parseInt(e.getText())== aidai.age) {
                Assert.assertEquals(e.getText(), String.valueOf(aidai.age));
            }
        }
    }
}
