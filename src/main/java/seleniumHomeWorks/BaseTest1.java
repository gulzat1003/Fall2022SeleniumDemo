package seleniumHomeWorks;

import intro.BrowserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest1 {

    WebDriver driver;
    BrowserHelper browserHelper;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Configure ChromeDriver to connect browser
        driver = new ChromeDriver(); // Creating instance of ChromeDriver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browserHelper = new BrowserHelper(driver);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//    }
}
