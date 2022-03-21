package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//a[@href='/computers']")
    WebElement computersMenu;

    @FindBy(xpath = "//a[@href='/notebooks']")
    WebElement notebooksMenu;

    @FindBy(xpath = "//h1[text()='Notebooks']")
    WebElement notebooksTitle;

    @FindBy(id = "products-pagesize")
    WebElement displayDropdownMenu;

    @FindBy(xpath="//select[@id='products-pagesize']/option[@value='9']")
    WebElement displayDropdownNine;

    @FindBy(xpath = "//input[@id='attribute-option-10']")
    WebElement filterCapacityTo16;

    @FindBy (xpath = "//p[text()='The product has been added to your ']")
    WebElement wishListNotification;

    @FindBy (xpath = "//p//a[text()='shopping cart']")
    WebElement shoppingCartNotification;

    @FindBy(xpath = "//span[@class='wishlist-qty']")
    WebElement wishlistLabel;

    @FindBy (xpath = "//span[@class='cart-qty']")
    WebElement cartLabel;

    public List<WebElement> cartListItems;
    public List<WebElement> wishListItems;
    public List<WebElement> productItems;

    public MainBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public void hoverToComputersMenu(){
        helper.hoverOver(computersMenu);
    }

    public void clickNotebooksMenu(){
        helper.clickOnElement(notebooksMenu);
    }
    public void clickDisplayDropdownMenu(){
        helper.clickOnElement(displayDropdownMenu);
    }
    public void clickDisplayDropdowNine(){
        helper.clickOnElement(displayDropdownNine);
    }

    public void addToCart(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        helper.clickOnElement(myElement);

    }

    public void addToWishList(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        helper.clickOnElement(myElement);
    }

    public List<WebElement> getProductItems(){
        productItems = driver.findElements(By.xpath("//div[@class='product-item']"));
        return productItems;
    }

    public List<WebElement> getCartList(){
        cartListItems = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        return cartListItems;
    }

    public List<WebElement> getWishListItems(){
        wishListItems = driver.findElements(By.xpath("//button[@title='Add to wishlist']"));
        return wishListItems;
    }


    public void filterCapacityTo16(){
        helper.clickOnElement(filterCapacityTo16);
    }

    public void waitForVisibilityOfNotebooksMenu(){
        helper.waitForElementToBeVisible(By.xpath("//a[@href='/notebooks']"));
    }
    public void waitForVisibilityOfDropdownNine(){
        helper.waitForElementToBeVisible(By.xpath("//select[@id='products-pagesize']/option[@value='9']"));
    }

    public String getNotebooksTitle(){
        return notebooksTitle.getText();
    }
    public String getNrItemsOnWishlistLabel(){
        return wishlistLabel.getText();
    }
    public String getNrItemsOnCartLabel(){
         return cartLabel.getText();
    }


    public WebElement getWishListNotification(){
        return wishListNotification;
    }
    public WebElement getShoppingCartNotification(){
        return shoppingCartNotification;
    }

}
