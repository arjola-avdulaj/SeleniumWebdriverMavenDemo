package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerMenu;
    @FindBy(id = "gender-male")
    WebElement radioM;
    @FindBy(id = "gender-female")
    WebElement radioF;
    @FindBy(id = "FirstName")
    WebElement firstname;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement day;
    @FindBy(name = "DateOfBirthMonth")
    WebElement month;
    @FindBy(name = "DateOfBirthYear")
    WebElement year;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Company")
    WebElement company;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "register-button")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='result']")
    WebElement registrationCompleteText;
    @FindBy(className = "ico-logout")
    WebElement logout;

    public RegisterBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

    public void insertDataOfNewUser(String gender,String fname,String lname,String dayStr,String monthStr,
                                    String yearStr,String emailStr,String companyStr,
                                    String passwordStr,String cpassword){
        if(gender.equals("Female"))
            helper.clickOnElement(radioF);
        else helper.clickOnElement(radioM);

        helper.insertText(firstname,fname);
        helper.insertText(lastName,lname);
        helper.insertDate(day,dayStr);
        helper.insertDate(month,monthStr);
        helper.insertDate(year,yearStr);
        helper.insertText(email,emailStr);
        helper.insertText(company,companyStr);
        helper.insertText(password,passwordStr);
        helper.insertText(confirmPassword,cpassword);
    }

    public void waitToClickRegisterButton(){
        helper.waitForElementToBeClickable(By.id("register-button"));
    }
    public void clickRegisterMenu(){
        helper.clickOnElement(registerMenu);
    }

    public void clickRegisterButton(){
        helper.clickOnElement(registerButton);
    }
    public void clickLogout(){
        helper.clickOnElement(logout);
    }
    public WebElement getRegistrationCompleteText(){
        return registrationCompleteText;
    }
}
