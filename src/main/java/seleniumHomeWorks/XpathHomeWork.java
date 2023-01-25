package seleniumHomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathHomeWork {
    WebDriver driver;
    String name;
    String email;
    String password;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://glovoapp.com/kg/ru/bishkek/");

    }
    @Test (description = "Find get started method")
    public void xPath1(){

        WebElement searchButton = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        searchButton.click();
    }
    @Test
    public void xpath2Test(){
        WebElement inputFirstName = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[2]"));
        inputFirstName.sendKeys("Gulzat");
        Assert.assertEquals(inputFirstName.getAttribute("value"), "Gulzat");
    }
    @Test
    public void xpath3Test(){
        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"signup-email\"]/div/input"));
        inputEmail.sendKeys(("test@gmail.com"));
        Assert.assertEquals(inputEmail.getAttribute("value"), "test@gmail.com");
    }

    @Test
    public  void xpath4Test(){
        WebElement inputPassword = driver.findElement((By.xpath("//*[@id=\"signup-password\"]/div/div/input")));
        inputPassword.sendKeys(("nur$123456"));
        Assert.assertEquals(inputPassword.getAttribute("value"), "nur$123456");
    }
    @Test
    public void xpath5Test(){
        WebElement loginButton = driver.findElement((By.xpath(("//*[@id=\"signup-button\"]/span"))));
        loginButton.click();
    }



//    @AfterClass
//    public void close(){
//        driver.close();
//        driver.quit();
//    }

}
