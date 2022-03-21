package com.sample.www.PageObjects;

import com.sample.www.BluePrints.LoginBlueprint;
import com.sample.www.BluePrints.RegisterBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject {
    WebDriver driver;
    RegisterBlueprint registerBlueprint;
    Helper helper;
    public RegisterPageObject(WebDriver driver){
        this.driver=driver;
        helper =new Helper(driver);
        registerBlueprint=new RegisterBlueprint(driver);
    }

    public void registerUser(String gender,String fname,String lname,String day,String month,
                             String year,String email,String company,String password,String cpassword){
        registerBlueprint.clickRegisterMenu();
        registerBlueprint.insertDataOfNewUser(gender,fname,lname,day, month,year,email,
                company,password,cpassword);
        registerBlueprint.waitToClickRegisterButton();
        registerBlueprint.clickRegisterButton();
    }

    public void logout(){
        registerBlueprint.clickLogout();
    }
}
