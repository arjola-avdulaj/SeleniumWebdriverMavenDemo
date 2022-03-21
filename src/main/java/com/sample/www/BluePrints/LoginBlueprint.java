package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBlueprint {
    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
    WebElement loginMenu;
    @FindBy(xpath = "//input[@class='email']")
    WebElement email;
    @FindBy(xpath = "//input[@class='password']")
    WebElement password;
    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    WebElement welcome;
    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;
    @FindBy(className = "ico-logout")
    WebElement logout;


    public LoginBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

    public String getWelcomeText(){
        helper.waitForElementToBeVisible(By.xpath("//div[@class='topic-block-title']/h2"));
        return welcome.getText();
    }

    public boolean isLogoutDisplayed() {
        return helper.isDisplayed(logout);
    }
    public void insertEmail(String str){
        helper.insertText(email,str);
    }
    public void insertPassword(String str){
        helper.insertText(password,str);
    }

    public void waitToClickLoginButton(){
        helper.waitForElementToBeClickable(By.xpath("//button[@class='button-1 login-button']"));
    }
    public void clickLoginButton(){
        helper.clickOnElement(loginButton);
    }
    public void clickLoginMenu(){
        helper.clickOnElement(loginMenu);
    }

}
