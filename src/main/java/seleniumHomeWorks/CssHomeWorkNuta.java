package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssHomeWorkNuta extends BaseTest1 {
//    @Test
//    public void sccTest1() throws InterruptedException {
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
//        List<WebElement> allBrands1 = driver.findElements(By.xpath("//div[@id= 'brandsRefinements']//ul/li/span/a"));
//        int count = 0;
//        for (WebElement s : allBrands1) {
//            count++;
//            System.out.println(s.getText());
//            if (s.getText().contains("SAMSUNG")) {
//                Helper.pause(3000);
//                driver.findElement(By.xpath("(//div[@id= 'brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
//
//                break;
//            }
//        }
//
//    }

//    @Test //Alisher
//    public void sccTest4() {
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
//        List<WebElement> brandNameElements = driver.findElements(By.xpath("//*[contains(@id,'p_89')]"));
//        String xpath1 = "//*[contains(@id,\'p_89')]";
//        String xpath2 = ")]/span/a/div/label/i";
//
//        for (WebElement d : brandNameElements) {
//            String input = d.getText();
//
//            if (d.getText().equals("SAMSUNG")) {
//                driver.findElement(By.xpath(xpath1 + input + xpath2)).click();
//
//                break;
//            }
//        }
//
//    }


    @Test // Kiyal
    public void cssTest2(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        driver.findElement((By.xpath(".//*[@id='brandsRefinements']/ul/li[8]/span/div/a/span")));
        WebElement allBrandsUL = driver.findElement(By.xpath(".//*[@id='brandsRefinements']/ul"));

        List<WebElement> allBrandsLi = allBrandsUL.findElements(By.tagName("li"));
        for (WebElement brand: allBrandsLi){
            System.out.println(brand.getText());
            if(brand.getText().equals("SAMSUNG")){
                Helper.pause(5000);
                System.out.println("_________________");
                brand.findElement(By.tagName("a")).click();

                break;
            }
        }
    }

//    @Test
//    public void sccTest3(){ // Belek
//
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
//        WebElement appleText = driver.findElement(By.cssSelector("li[id= 'p_89/Apple']"));
//        System.out.println(appleText.getText());
//        WebElement allBrandsUL = driver.findElement(By.xpath(".//*[@id='brandsRefinements']/ul"));
//
//        List<WebElement> allBrands2 = driver.findElements(By.xpath("//li[contains(@id,'p_89/')]"));
//        for(WebElement j: allBrands2) {
//            System.out.println(j.getText());
//            if(j.getText().equals("SAMSUNG")) {
//                Helper.pause(3000);
//                System.out.println("----------------");
//                j.findElement(By.tagName("i")).click();
//                break;
//
//            }
//        }
//    }

//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung", Keys.ENTER);
//        WebElement samsungTest = driver.findElement(By.xpath("//*[@id='p_89/Generic']"));
//        samsungTest.click();
//        //#twotabsearchtextbox


}
