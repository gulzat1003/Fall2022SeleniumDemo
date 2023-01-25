package seleniumHomeWorks;

import com.github.javafaker.Faker;
import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorkWebDriver extends BaseTest1 {

    @Test
    public void test1() {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName"));
        Faker faker = new Faker();
        String fName = faker.name().name();
        String lName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String age = String.valueOf(faker.number().randomDigit());
        String salary = String.valueOf(faker.number().randomDigit());
        String department = faker.job().field();

        WebElement fullNameInput = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email2 = driver.findElement(By.id("userEmail"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement salaryInput = driver.findElement(By.id("salary"));
        WebElement departmentInput = driver.findElement(By.id("department"));

        fullNameInput.sendKeys(fName);
        lastName.sendKeys(lName);
        email2.sendKeys(email);
        ageInput.sendKeys(age);
        salaryInput.sendKeys(salary);
        departmentInput.sendKeys(department);


        driver.findElement(By.id("submit")).click();
        Helper.pause(3000);

        List<WebElement> saveData = driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        for (WebElement j : saveData) {
            if (j.getText().equals(fName))
                Assert.assertTrue(j.getText().contains(fName));
            System.out.println(j.getText());
            if (j.getText().equals(lName))
                Assert.assertTrue(j.getText().contains(lName));
            if (j.getText().equals(email))
                Assert.assertTrue(j.getText().contains(email));
            if (j.getText().equals(age))
                Assert.assertTrue(j.getText().contains(age));
            if (j.getText().equals(salary))
                Assert.assertTrue(j.getText().contains(salary));
            if (j.getText().equals(department))
                Assert.assertTrue(j.getText().contains(department));


        }


    }


}
