package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(className = "ico-login")
    WebElement loginMenu;

    public HomePageBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

    public void waitToClickLoginMenu(){
        helper.waitForElementToBeClickable(By.className("ico-login"));
    }
    public void clickLoginMenu(){
        helper.clickOnElement(loginMenu);
    }


}
