package com.sample.www.PageObjects;

import com.sample.www.BluePrints.ShoppingCartBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPageObject {
    WebDriver driver;
    ShoppingCartBlueprint shoppingCartBlueprint;
    Helper helper;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
        shoppingCartBlueprint=new ShoppingCartBlueprint(driver);
        helper = new Helper(driver);

    }

    public boolean isGoToCartDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.getGoToCart());
    }

    public boolean isUpdateCartDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.getUpdateCart());
    }

    public boolean isContinueShoppingDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.getContinueShopping());
    }
    public boolean isEstimateShippingDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.getEstimateShipping());
    }

    public void hoverToShoppingCartMenu_andGoToCart(){
        shoppingCartBlueprint.hoverToShoppingCart();
        helper.waitForElementToBeVisible(By.xpath("//button[@class='button-1 cart-button']"));
    }

    public void clickGoToCart(){
        helper.clickOnElement(shoppingCartBlueprint.getGoToCart());
    }

    public void removeItemFromCart(int position){
        List<WebElement> elements = shoppingCartBlueprint.getCartItems();
        helper.waitForAWhile();
        shoppingCartBlueprint.removeElementFromCart(elements,position-1);
        helper.waitForAWhile();
    }

    public void emptyShoppingCart(){
        List<WebElement> elements = shoppingCartBlueprint.getCartItems();
        for(int i=0; i<elements.size(); i++){
            removeItemFromCart(1);
        }
    }

    public double getPricesSum(){
        List<WebElement> elements = shoppingCartBlueprint.getSubtotalList();
        List<Double> subtotals = shoppingCartBlueprint.getSubtotals(elements);
        double sum = shoppingCartBlueprint.getSum(subtotals);
        return sum;
    }
}
