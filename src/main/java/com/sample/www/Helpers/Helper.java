package com.sample.www.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper {
    WebDriver driver;
    WebDriverWait wait;

    public Helper(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    }

    public void insertDate(WebElement element,String str){
        Select date = new Select(element);
        date.selectByVisibleText(str);
    }
    public void clickOnElement(WebElement element){element.click();}
    public void insertText(WebElement element, String str){element.sendKeys(str);}
    public void hoverOver(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public int getNrItems(List<WebElement> elements){
        return elements.size();
    }

    public boolean isDisplayed(WebElement element){
        return(element.isDisplayed());
    }

    public double getTextAndParseToDouble(WebElement element){
        String str= element.getText();
        String newStr = str.replaceAll("[$,]", "");
        return Double.parseDouble(newStr);
    }
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForAWhile() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
