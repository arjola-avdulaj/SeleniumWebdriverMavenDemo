package com.sample.www.PageObjects;

import com.sample.www.BluePrints.LoginBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    WebDriver driver;
    LoginBlueprint loginBlueprint;
    Helper helper;
    public LoginPageObject(WebDriver driver){
        this.driver=driver;
        loginBlueprint =new LoginBlueprint(driver);
        helper =new Helper(driver);
    }

    public void loginUserWithCredentials(String email,String password){
        loginBlueprint.clickLoginMenu();
        loginBlueprint.insertEmail(email);
        loginBlueprint.insertPassword(password);
        loginBlueprint.waitToClickLoginButton();
        loginBlueprint.clickLoginButton();
    }
}
