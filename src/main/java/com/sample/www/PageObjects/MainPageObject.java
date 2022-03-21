package com.sample.www.PageObjects;

import com.sample.www.BluePrints.MainBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageObject {

    WebDriver driver;
    MainBlueprint mainBlueprint;
    Helper helper;

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
        mainBlueprint = new MainBlueprint(driver);
        helper=new Helper(driver);
    }

    public void hoverToComputersMenu_andClickNotebooks(){
        mainBlueprint.hoverToComputersMenu();
        mainBlueprint.waitForVisibilityOfNotebooksMenu();
        mainBlueprint.clickNotebooksMenu();
    }

    public void display9Items(){
        mainBlueprint.clickDisplayDropdownMenu();
        mainBlueprint.waitForVisibilityOfDropdownNine();
        mainBlueprint.clickDisplayDropdowNine();
    }

    public void selectMemory16gb(){
        helper.waitForAWhile();
        mainBlueprint.filterCapacityTo16();
        helper.waitForAWhile();

    }

    public int numberOfProductItems(){
        List<WebElement> items = mainBlueprint.getProductItems();
        int actual = helper.getNrItems(items);
        return actual;
    }
    public void addItemToWishList(int num){
        List<WebElement> items = mainBlueprint.getWishListItems();
        helper.waitForAWhile();
        mainBlueprint.addToWishList(items,num-1);
        helper.waitForAWhile();

    }

    public void addItemToCartList(int num){
        List<WebElement> items = mainBlueprint.getCartList();
        helper.waitForAWhile();
        mainBlueprint.addToCart(items,num-1);
        helper.waitForAWhile();

    }

    public boolean isWishListNotificationDisplayed() {
        return helper.isDisplayed(mainBlueprint.getWishListNotification());
    }

    public boolean isShoppingCartNotificationDisplayed() {
        return helper.isDisplayed(mainBlueprint.getShoppingCartNotification());
    }

}
