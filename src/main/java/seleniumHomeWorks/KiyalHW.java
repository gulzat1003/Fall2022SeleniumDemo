package seleniumHomeWorks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KiyalHW extends BaseTest1{
    String firstName = KiyalFakeDataProvider.generateFakeName();
    String lastName = KiyalFakeDataProvider.generateLastFakeName();
    String email = KiyalFakeDataProvider.generateFakeEmailAddress();
    int age = randomNumber();
    int salary = randomNumber2();
    String department = KiyalFakeDataProvider.generateFakeJob();
    String firstName2 = KiyalFakeDataProvider.generateFakeName();
    String lastName2 = KiyalFakeDataProvider.generateLastFakeName();
    String email2 = KiyalFakeDataProvider.generateFakeEmailAddress();
    int age2 = randomNumber();
    int salary2 = randomNumber2();
    String department2 = KiyalFakeDataProvider.generateFakeJob();
    public static int randomNumber() {
        int a = 0;
        int b = 100;
        return a + (int) (Math.random() * b);
    }
    public static int randomNumber2() {
        int a = 0;
        int b = 100000;
        return a + (int) (Math.random() * b);
    }

    @Test
    public void toAdd(){
        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(Integer.toString(age));
        driver.findElement(By.id("salary")).sendKeys(Integer.toString(salary));
        driver.findElement(By.id("department")).sendKeys(department);
        driver.findElement(By.id("submit")).click();
        Helper.pause(2000);

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName2);
        driver.findElement(By.id("lastName")).sendKeys(lastName2);
        driver.findElement(By.id("userEmail")).sendKeys(email2);
        driver.findElement(By.id("age")).sendKeys(Integer.toString(age2));
        driver.findElement(By.id("salary")).sendKeys(Integer.toString(salary2));
        driver.findElement(By.id("department")).sendKeys(department2);
        driver.findElement(By.id("submit")).click();
        Helper.pause(2000);

    }
    @Test(dependsOnMethods = {"toAdd"})
    public void testWebTable(){

        WebElement table = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        List<WebElement> allRows = table.findElements(By.className("rt-tr-group"));

        for (WebElement row: allRows) {
            List<WebElement> allColumns = row.findElements(By.className("rt-td"));
            for (WebElement column: allColumns) {
                if(column.getText().equals(firstName)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),firstName);
                }
                if(column.getText().equals(lastName)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),lastName);
                }
                if(column.getText().equals(email)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),email);
                }
                if(column.getText().equals(String.valueOf(age))){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),String.valueOf(age));
                }
                if(column.getText().equals(String.valueOf(salary))){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(), String.valueOf(salary));
                }
                if(column.getText().equals(department)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),department);
                }
            }

            for (WebElement column: allColumns) {
                if(column.getText().equals(firstName2)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),firstName2);
                }
                if(column.getText().equals(lastName2)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),lastName2);
                }
                if(column.getText().equals(email2)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),email2);
                }
                if(column.getText().equals(String.valueOf(age2))){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),String.valueOf(age2));
                }
                if(column.getText().equals(String.valueOf(salary2))){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(), String.valueOf(salary2));
                }
                if(column.getText().equals(department2)){
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(),department2);
                }
            }
        }
    }
    }




