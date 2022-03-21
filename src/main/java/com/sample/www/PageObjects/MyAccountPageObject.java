package com.sample.www.PageObjects;

import com.sample.www.BluePrints.MyAccountBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.WebDriver;

public class MyAccountPageObject {

    WebDriver driver;
    MyAccountBlueprint myAccountBlueprint;
    Helper helper;

    public MyAccountPageObject(WebDriver driver){
        this.driver=driver;
        myAccountBlueprint = new MyAccountBlueprint(driver);
        helper=new Helper(driver);
    }

    public void clickMyAccount(){
        myAccountBlueprint.clickMyAccount();
        helper.waitForAWhile();
    }

    public void logoutUser(){
        myAccountBlueprint.clickLogout();
        helper.waitForAWhile();
    }
}
