package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest {
    @Test
    public void demo1() {
        //NoSuchElementException. When we put wrong element

        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Hello world");
    }

    @Test
    public void noSuchWindowException() {
        //noSuchWindowException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("4");

    }

    @Test
    public void noSuchFrameException() {
        //NoSuchFrameException
        /*Webdriver attempts to switch to an invalid frame, which is unavailable
        (Webdriver пытается переключиться на недопустимый фрейм, который недоступен)*/
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);

    }
    @Test
    public void noSuchAlertException() {
        //NoAlertPresentException
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }

    @Test
    public void invalidSelectorException() {
        //InvalidSelectorException // when we put by locator like xpath or scc selection
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//button[@type='button'][100]"));
    }

    @Test
    public void noSuchSessionException() {
        //NoSuchSessionException
        driver.quit(); // session and all tubs apparently closed because before to call this site we use quite
        browserHelper.openURL("https://demoqa.com/text-box");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session Id is" + s);
    }

    @Test
    public void staleElementExceptionTest() {
        //    StaleElementReferenceException
     /*The Stale Element Reference Exception is a runtime error. It occurs when test code
     uses an object and at that time the object's state changes.
     Элемент, на который указывает ссылка, больше не присутствует на странице DOM (ссылка на компонент теперь устарела).
       Например, элемент принадлежит другому фрейму, отличному от текущего, или пользователь перешел на другую страницу.*/

        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();

            }
        }
    }
    @Test
    public void timeOutException(){
        //timeOutException
        /*Команда не была выполнена в указанное время.
        Например, элемент не отображался в указанное время. Особенно это встречается при работе с ожиданиями/
         */
        browserHelper.openURL("https://demoqa.com/text-box");
  //      driver.findElement(By.id("enableAfter")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
    }
    @Test
    public void elementNotInteractible(){
        //ElementNotInteractableException
        /*This exception is thrown if a webelement exists in DOM (Document Object Model)  but cannot be accessed.*/
//        browserHelper.openURL("https://demoqa.com/text-box");
//        driver.findElement(By.id("userName")).click();
        browserHelper.openURL("https://demoqa.com/radio-button");// драйвер не может с ним взаимодействовать, мы с ним неправильно взаимодействуем
        //          driver.findElement(By.id("noRadio")).click();
        driver.findElement(By.id("noRadio")).sendKeys("saas"); // в кнопку пытаемся что-то написать
    }

    @Test
    public void webElementException(){

    }
    @Test
    public void elementNotSelectableException(){
        /*An element is disabled (can not be clicked/selected) in spite of being present in the DOM
        //Элемент отключен (нельзя щелкнуть/выбрать), несмотря на то, что он присутствует в DOM.*/


    }
    @Test
    public void elementNotVisibleException(){

    }
    @Test
    public void elementClickInterceptedException(){
           // ElementClickInterceptedException / элемент не активный
            browserHelper.openURL("https://www.imoving.com/");
            WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
            Select select = new Select(selectMenu);
            select.selectByVisibleText("My House");
            Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
            select1.selectByVisibleText("Just a few Items");
            driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
            Helper.pause(3000);
            driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
            Helper.pause(3000);
            driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click(); //пытаемся кликнуть недоступный элемент
            Helper.pause(3000);
        }


    @Test
    public void javascriptException(){

    }
    @Test
    public void noSuchAttributeException(){
 //       driver.get("<your_url>");
//
//        // trying to retrieve the "foo-button" HTML element
//       WebElement fooButton = driver.findElement(By.id("foo-button"));

    }
}
