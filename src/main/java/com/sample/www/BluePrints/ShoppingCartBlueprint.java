package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement shoppingCartMenu;

    @FindBy(xpath = "//button[@class='button-1 cart-button']")
    WebElement goToCart;

    @FindBy(xpath = "//h1[text()='Shopping cart']")
    WebElement shoppingCartTitle;

    @FindBy(id = "updatecart")
    WebElement updateCart;

    @FindBy(name = "continueshopping")
    WebElement continueShopping;

    @FindBy(id = "open-estimate-shipping-popup")
    WebElement estimateShipping;

    @FindBy(xpath = "//span//strong")
    WebElement totalAmount;


 //   @FindBys({@FindBy(xpath = "//span//strong")})
 //   List<WebElement>   items;

    public List<WebElement> removeButtonsList;
    public List<WebElement> subtotalList;

    public ShoppingCartBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public void hoverToShoppingCart(){
        helper.hoverOver(shoppingCartMenu);
    }

    public String getShoppingCartTitle(){
        return shoppingCartTitle.getText();
    }
    public List<WebElement> getCartItems(){
        removeButtonsList = driver.findElements(By.xpath("//td[@class='remove-from-cart']"));
        return removeButtonsList;
    }

    public List<WebElement> getSubtotalList(){
        subtotalList = driver.findElements(By.xpath("//td[@class='subtotal']//span"));
        return subtotalList;
    }

    public List<Double> getSubtotals(List<WebElement> elements){
        List<Double> subtotals = new ArrayList<>();

        for(int i=0; i< elements.size(); i++){
            subtotals.add(helper.getTextAndParseToDouble(elements.get(i)));
        }
        return subtotals;
    }

    public double getSum(List<Double> elements){
        double sum=0;
        for(int i=0; i< elements.size(); i++){
            sum+=elements.get(i);
        }
        return sum;
    }

    public WebElement getGoToCart(){
        return goToCart;
    }
    public WebElement getUpdateCart(){
        return updateCart;
    }
    public WebElement getContinueShopping(){
        return continueShopping;
    }
    public WebElement getEstimateShipping(){
        return estimateShipping;
    }

    public double getTotalAmount(){
        return helper.getTextAndParseToDouble(totalAmount);
    }

    public int getNrItemsOnCart(){
        removeButtonsList = driver.findElements(By.xpath("//td[@class='remove-from-cart']"));

        if(removeButtonsList.size()<1)
            return 0;
        return removeButtonsList.size();
    }
    public void removeElementFromCart(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        helper.clickOnElement(myElement);
    }

}
