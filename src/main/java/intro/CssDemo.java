package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {
    @Test
    public void cssTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        // WebElement searchInpute - we're saving value in order to reuse / by name I can call as much as possible
        // if we don't need to save in container and in further don't need to use than we can put directly in driver.findElement
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        //findElement - находит только один элемент
        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());
        // все элементы мы должны положить куда-то, положили в List/ findElements -находит все элементы
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']"));
        for (WebElement e : allBrands) {
            System.out.println(e.getText());

          if (e.getText().contains("Samsung")){
                driver.findElement(By.xpath("//*[@id='p_89/SAMSUNG']/span/a/div/label/i")).click();
            }
        }
        Thread.sleep(3000);


        }
//        WebElement seeMore = driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[12]"));
//        seeMore.click();


    }

