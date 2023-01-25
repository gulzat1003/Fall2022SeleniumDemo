package seleniumPractice;

//import com.github.javafaker.Faker;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import static org.testng.Assert.*;
//
//import java.time.Duration;
//
//public class HomeWorkSelenium1 {
//    static Faker faker = new Faker();
//    static WebDriver driver;
//
//    @BeforeClass
//    public static void settings(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.get("https://demoqa.com/text-box");
//    }
//
//    @Test
//    public static void CheckForm() throws InterruptedException {
//
//        //Arrange
//        String Name = generateFakeFullName();
//        String Email = generateFakeEmail();
//        String CurrentAddress = generateFakeAddress();
//        String PermanentAddress = generateFakePermanentAddress();
//
//        String checkName;
//        String checkEmail;
//        String checkCurrentAddress;
//        String checkPermanent;
//
//        //Act
//        WebElement fullInputFieldName = driver.findElement(By.id("userName"));
//        fullInputFieldName.sendKeys(Name);
//
//        WebElement fullInputFieldEmail = driver.findElement(By.id("userEmail"));
//        fullInputFieldEmail.sendKeys(Email);
//
//        WebElement fullInputFieldCurrAddress = driver.findElement(By.id("currentAddress"));
//        fullInputFieldCurrAddress.sendKeys(CurrentAddress);
//
//        WebElement fullInputFieldPermanentAddress = driver.findElement(By.id("permanentAddress"));
//        fullInputFieldPermanentAddress.sendKeys(PermanentAddress);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)", "");
//
//        Thread.sleep(3000);
//
//        WebElement clickSubmitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
//        clickSubmitButton.click();
//
////        Thread.sleep(3000);
//
//
//        //Assert
//        WebElement checkNameInput = driver.findElement(By.cssSelector("#name"));
//        checkName = checkNameInput.getText();
//        assertEquals(checkName, "Name:"+Name);
//
//        WebElement checkEmailInput = driver.findElement(By.cssSelector("#email"));
//        checkEmail = checkEmailInput.getText();
//        assertEquals(checkEmail, "Email:"+Email);
//
//        WebElement checkCurrentAddressInput = driver.findElement(By.cssSelector("p#currentAddress"));
//        checkCurrentAddress = checkCurrentAddressInput.getText();
//        assertEquals(checkCurrentAddress, "Current Address :"+CurrentAddress);
//
//        WebElement checkPermanentInput = driver.findElement(By.cssSelector("p#permanentAddress"));
//        checkPermanent = checkPermanentInput.getText();
//        assertEquals(checkPermanent, "Permananet Address :" + PermanentAddress);
//
//
//    }
//
//    public static String generateFakeFullName(){return faker.name().fullName();}
//    public static String generateFakeEmail(){return faker.internet().emailAddress();}
//    public static String generateFakeAddress(){return faker.address().city();}
//    public static String generateFakePermanentAddress(){return faker.address().streetAddress();}
//}
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWorkSelenium1 {

    WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();

    String name;
    String email;
    String currentAdress;
    String permanentAdress;

    String expectedFakeName;
    String expectedFakeEmail;
    String fakeAddress;
    String fakePerAddress;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://demoqa.com/text-box");

    }
    @Test(description = "Should run first.", priority = 1)
    public void submitTesting() {

        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        currentAdress = faker.address().country();
        permanentAdress = faker.address().city();

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(name);

        WebElement emailInputField = driver.findElement(By.id("userEmail"));
        emailInputField.sendKeys(email);

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys(currentAdress);

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys(permanentAdress);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Test(priority = 2)
    public void assertTestingName() {

        expectedFakeName = driver.findElement(By.id("name")).getText();
        assertTrue(expectedFakeName.contains(name), " Name is Ok");
    }
    @Test(priority = 3)
    public void assertTestingEmail() {
        expectedFakeEmail = driver.findElement(By.id("email")).getText();
        assertEquals("Email:" + email, expectedFakeEmail, "Email is failed");

    }
    @Test(priority = 4)
    public void assertTestingAddress() {
        fakeAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
        assertTrue(fakeAddress.contains(currentAdress), "current address is ok");

    }

    @Test(priority = 5)
    public void assertTestingPerAddress() {
        fakePerAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")).getText();
        assertTrue(fakePerAddress.contains(permanentAdress), "permanent address is ok");
    }
    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }

}









