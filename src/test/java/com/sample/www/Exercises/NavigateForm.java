package com.sample.www.Exercises;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateForm extends TestBase {
    @Test
    public void navigate() throws InterruptedException {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Arjola");

        driver.manage().window().maximize();

        String baseUrl = "https://demo.nopcommerce.com/";
        driver.get(baseUrl);

        //kliko login
        WebElement loginMenu = driver.findElement(By.className("ico-login"));
        loginMenu.click();

        WebElement registerButton = driver.findElement(By.className("register-button"));
        registerButton.click();

        System.out.println(driver.getTitle());

        WebElement radioM = driver.findElement(By.id("gender-male"));
        WebElement radioF = driver.findElement(By.id("gender-female"));
        radioF.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Arjola");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Avdulaj");

        WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        day.sendKeys("2");
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("1");
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        year.sendKeys("2002");

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("arjolaavdulaj111@gmail.com");

        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("Lufthansa Industry Solutions");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Arjola123");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Arjola123");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.id("register-button"));
        submitButton.click();
        String expectedPostRegisterUrl = driver.getCurrentUrl();

        WebElement regComplete = driver.findElement(By.xpath("//div[@class='result']"));
        if(regComplete.isDisplayed())
            System.out.println("Registration Complete");

        //validate
    //    String actualPostRegisterUrl = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
      //  Assert.assertEquals(actualPostRegisterUrl, expectedPostRegisterUrl);

        //log out
        WebElement logout = driver.findElement(By.className("ico-logout"));
        logout.click();

        //login
        WebElement login1 = driver.findElement(By.className("ico-login"));
        login1.click();
        WebElement email1 = driver.findElement(By.id("Email"));
        email1.sendKeys("arjolaavdulaj111@gmail.com");

        WebElement password1 = driver.findElement(By.id("Password"));
        password1.sendKeys("Arjola123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        //verificate login
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(4000);

        String actualPostLoginUrl = "https://demo.nopcommerce.com/";
        String expectedPostLoginUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPostLoginUrl, expectedPostLoginUrl);

        WebElement welcome = driver.findElement(By.xpath("//div[@class='topic-block-title']/h2"));
        WebElement logout1 = driver.findElement(By.className("ico-logout"));

        if(welcome.isDisplayed() && logout1.isDisplayed()){
            System.out.println("PASS");
        }
        else System.out.println("FAIL");

        logout1.click();
        Thread.sleep(4000);


        driver.close();


    }
}
