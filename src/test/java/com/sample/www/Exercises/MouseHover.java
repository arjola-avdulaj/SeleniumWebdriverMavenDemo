package com.sample.www.Exercises;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover extends TestBase {
    @Test
    public void mouseHover() throws InterruptedException {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Arjola");

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/menu/#");
        Actions action = new Actions(driver);

        WebElement mainItem2  = driver.findElement(By.xpath("//a[text()=';Main Item 2']"));
        action.moveToElement(mainItem2);
        Thread.sleep(5000);

        WebElement submenu1 = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(submenu1);
        Thread.sleep(5000);

        WebElement submenu2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        submenu2.click();
        Thread.sleep(5000);

        driver.close();

    }
}
