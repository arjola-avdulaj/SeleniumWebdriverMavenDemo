package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountMenu;
    @FindBy(xpath = "//h1[text()='My account - Customer info']")
    WebElement pageTitle;
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutMenu;
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

    public MyAccountBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

    public void clickMyAccount(){
        helper.clickOnElement(myAccountMenu);
    }
    public void clickLogout(){
        helper.clickOnElement(logoutMenu);
    }

    public String getGender(){
        if(radioF.isSelected())
            return"Female";
        else return "Male";
    }

    public String getFirstName(){
        return firstname.getAttribute("value");
    }
    public String getLastName(){
        return lastName.getAttribute("value");
    }
    public String getDay(){
        return day.getAttribute("value");
    }
    public String getMonth(){
        return month.getAttribute("value");
    }
    public String getYear(){
        return year.getAttribute("value");
    }
    public String getEmail(){
        return email.getAttribute("value");
    }

    public String getCompany(){
        return company.getAttribute("value");
    }

    public String getMyAccountTitle(){
        return pageTitle.getText();
    }

}
