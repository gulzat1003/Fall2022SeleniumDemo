package intro;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void openURL(String URL){
        driver.navigate().to(URL);
    }
    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();
    }
    public void refreshThePage(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles() { // No index in Set, we can't call by index that's why we create new method below
        return driver.getWindowHandles(); // all tubs been put in Set in order to sort out / этот меттод возвращает все складки которые есть
                                         // all new tub will be in this method to avoid duplicates
    }
    public void switchToWindow(int index) { // with help of this method we can switch window
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles()); // in order to work with index we create LinkedList where we can call by index.

        if(index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid index " + index);

        }
        driver.switchTo().window(windowsId.get(index));
    }
    public void switchToParent (){
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
    }

}
