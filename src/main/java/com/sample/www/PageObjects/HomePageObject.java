package com.sample.www.PageObjects;

import com.sample.www.BluePrints.HomePageBlueprint;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
    WebDriver driver;
    HomePageBlueprint helper;
    public HomePageObject(WebDriver driver){
        this.driver=driver;
    }

    public void navigateAndClickLogin(){
        helper=new HomePageBlueprint(driver);
        //wait
        helper.waitToClickLoginMenu();
        helper.clickLoginMenu();
    }
}
