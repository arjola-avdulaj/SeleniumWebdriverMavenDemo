package com.sample.www.Exercises;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class RightClick extends TestBase {
    @Test
    public void rightClick() throws InterruptedException {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Arjola");

        driver.manage().window().maximize();;
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        Actions action = new Actions(driver);
        WebElement clickMe = driver.findElement(By.cssSelector(".context-menu-one"));
        action.contextClick(clickMe).perform();
        Thread.sleep(5000);

        WebElement edit = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        edit.click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        driver.close();

    }

}
