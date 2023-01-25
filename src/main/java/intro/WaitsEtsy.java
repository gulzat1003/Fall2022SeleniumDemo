package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsEtsy extends BaseTest {

    @Test
    public void testExplicate() {
        driver.navigate().to("http://demoqa.com/dynamic-properties");
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();

        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),
                "class", "text-danger"));

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        System.out.println(colorChange.getText());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();

    }

    @Test
    public void etsySignIn() {
        driver.navigate().to("https://www.etsy.com/?ref=lgo");
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
        signInBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("join-neu-overlay-title")));

        driver.findElement(By.xpath("//button[contains(text(),'Зарегистрироваться')]")).click();
        Helper.pause(1000);

        WebElement joinNewEmail = driver.findElement(By.xpath(".//input[@id='join_neu_email_field']"));
        joinNewEmail.sendKeys("bloomingTest353@gmail.com");
        Helper.pause(1000);

        WebElement joinNewName = driver.findElement(By.id("join_neu_first_name_field"));
        joinNewName.sendKeys("User");
        Helper.pause(1000);

        WebElement joinNewPassword = driver.findElement(By.id("join_neu_password_field"));
        joinNewPassword.sendKeys("testLevel123");
        Helper.pause(1000);

        WebElement registration = driver.findElement(By.xpath("(//div[@class='wt-validation'])"));
        registration.click();
        Helper.pause(2000);

        driver.findElement(By.xpath("//div[@class='query-with-image-text--border']")).click();
        Helper.pause(1000);

        driver.findElement(By.xpath("(//div[@class='height-placeholder'])[5]")).click();
        Helper.pause(1000);


        //My project / card and rings
//        driver.findElement(By.xpath("(//span[@class= 'wt-icon'])[2]")).click();
//        Helper.pause(1000);
//        driver.findElement(By.id("global-enhancements-search-query")).click();
//        Helper.pause(1000);
//        driver.findElement(By.xpath(".//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")).click();
//        driver.findElement(By.xpath("(//div[@class='wt-pt-xs-1 category-grid-text-width-center'])[4]")).click();
//        driver.findElement(By.xpath("(//p[@class='ingress-title wt-text-truncate--multi-line wt-text-caption-title child-hover-underline'])[3]")).click();
//        driver.findElement(By.xpath("//p[contains(text(), 'Обручальные и помолвочные')]")).click();
//        driver.findElement(By.xpath(".//p[text()='Минимализм']")).click();
//        driver.findElement(By.xpath("(//div[@class='height-placeholder'])[20]")).click();

//        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
//        Select select2 = new Select(moveSizeMenu);
//        select2.selectByVisibleText("Just a few Items");
//        Helper.pause(3000);

//        WebElement selectOfSize = driver.findElement(By.xpath("//select[@id='variation-selector-0']"));
//        Select select = new Select(selectOfSize);
//        select.deselectByVisibleText("Выберите вариант");

    }
}
