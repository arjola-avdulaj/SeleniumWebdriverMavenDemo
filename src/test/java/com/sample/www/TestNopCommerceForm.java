package com.sample.www;

import com.sample.www.BluePrints.*;
import com.sample.www.PageObjects.*;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TestNopCommerceForm extends TestBase {

    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    LoginBlueprint loginBlueprint;
    RegisterPageObject registerPageObject;
    MainPageObject mainPageObject;
    MainBlueprint mainBlueprint;
    MyAccountPageObject myAccountPageObject;
    MyAccountBlueprint myAccountBlueprint;
    ShoppingCartPageObject shoppingCartPageObject;
    ShoppingCartBlueprint shoppingCartBlueprint;
    static Random randomGenerator = new Random();
    static int randomInt = randomGenerator.nextInt(1000);
    public static String em = "arjolaavdulaj" + randomInt+"@gmail.com";
    int actualItemsDisplayed;

    @Test
    public void registerTest(){

        //navigate and click login
        homePageObject=new HomePageObject(driver);
        homePageObject.navigateAndClickLogin();

        //register user
        registerPageObject=new RegisterPageObject(driver);
        registerPageObject.registerUser("Female","Arjola","Avdulaj", "2", "January",
                "2002",em,"Lufthansa Industry Solutions","arjola123", "arjola123");
        registerPageObject.logout();
    }

    @Test
    public void loginTest(){
        registerTest();

        //login user
        loginPageObject=new LoginPageObject(driver);
        loginPageObject.loginUserWithCredentials(em,"arjola123");

        //verify login
        loginBlueprint = new LoginBlueprint(driver);
        //welcome is displayed
        String welcomeText = loginBlueprint.getWelcomeText();
        Assert.assertEquals(welcomeText,"Welcome to our store");
        //logout is displayed
        Assert.assertTrue(loginBlueprint.isLogoutDisplayed());

    }

    @Test
    public void myAccountTest() throws InterruptedException {
        //open page, register user and login
         registerTest();
         loginTest();


        //click my account menu
        myAccountPageObject = new MyAccountPageObject(driver);
        myAccountPageObject.clickMyAccount();

        //verify title
        myAccountBlueprint = new MyAccountBlueprint(driver);
        String actualMyAccountTitle = myAccountBlueprint.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountTitle, "My account - Customer info");

        //verify the fields are the same as in Register test
        String actualGender = myAccountBlueprint.getGender();
        Assert.assertEquals(actualGender, "Female");

        String actualFirstName = myAccountBlueprint.getFirstName();
        Assert.assertEquals(actualFirstName, "Arjola");

        String actualLastName = myAccountBlueprint.getLastName();
        Assert.assertEquals(actualLastName,"Avdulaj");

        String actualDay = myAccountBlueprint.getDay();
        Assert.assertEquals(actualDay, "2");

        String actualMonth = myAccountBlueprint.getMonth();
        Assert.assertEquals(actualMonth, "1");

        String actualYear = myAccountBlueprint.getYear();
        Assert.assertEquals(actualYear,"2002");

        String actualEmail = myAccountBlueprint.getEmail();
        Assert.assertEquals(actualEmail,em);
        Thread.sleep(3000);

        String actualCompany = myAccountBlueprint.getCompany();
        Assert.assertEquals(actualCompany,"Lufthansa Industry Solutions");
        Thread.sleep(3000);

        //logout
        myAccountPageObject.logoutUser();
    }

    @Test
    public void dashboardTest() throws InterruptedException {

        //open page, register user and login
        registerTest();
        loginTest();

        mainBlueprint=new MainBlueprint(driver);

        //open notebooks
        mainPageObject=new MainPageObject(driver);
        mainPageObject.hoverToComputersMenu_andClickNotebooks();
        Thread.sleep(5000);

        //Verify title
        String expected = "Notebooks";
        String actual = mainBlueprint.getNotebooksTitle();
        Assert.assertEquals(actual,expected);

        //choose 9 on display
        mainPageObject.display9Items();
        Thread.sleep(5000);

        //verify 6 items are displayed
        actualItemsDisplayed = mainPageObject.numberOfProductItems();
        Assert.assertEquals(actualItemsDisplayed,6);

        //filter to 16 GB and verify 1 item is displayed
        Thread.sleep(5000);
        mainPageObject.selectMemory16gb();
        Thread.sleep(5000);
        actualItemsDisplayed = mainPageObject.numberOfProductItems();
        Assert.assertEquals(actualItemsDisplayed,1);
        Thread.sleep(5000);


        //unselect 16 and verify
        Thread.sleep(5000);
        mainPageObject.selectMemory16gb();
        Thread.sleep(5000);
        actualItemsDisplayed = mainPageObject.numberOfProductItems();
        Thread.sleep(5000);

        //add items 2 and 3 to wishlist and verify a notification is displayed
        Thread.sleep(5000);
        mainPageObject.addItemToWishList(2);
        Assert.assertTrue(mainPageObject.isWishListNotificationDisplayed());

        Thread.sleep(5000);
        mainPageObject.addItemToWishList(3);
        Assert.assertTrue(mainPageObject.isWishListNotificationDisplayed());

        //add items 4 5 6 to cart and verify notification is displayed
        Thread.sleep(5000);
        mainPageObject.addItemToCartList(4);
        Assert.assertTrue(mainPageObject.isShoppingCartNotificationDisplayed());
        Thread.sleep(5000);
        mainPageObject.addItemToCartList(5);
        Assert.assertTrue(mainPageObject.isShoppingCartNotificationDisplayed());
        Thread.sleep(5000);
        mainPageObject.addItemToCartList(6);
        Assert.assertTrue(mainPageObject.isShoppingCartNotificationDisplayed());
        Thread.sleep(5000);

        //verify number of items in each menu
        String numOfWishlistItems = mainBlueprint.getNrItemsOnWishlistLabel();
        Assert.assertEquals(numOfWishlistItems, "(2)");
        Thread.sleep(3000);

        String numOfCartItems = mainBlueprint.getNrItemsOnCartLabel();
        Assert.assertEquals(numOfCartItems, "(3)");


    }

    @Test
    public void shoppingCartTest() throws InterruptedException {
        //precondition: dashboard test
        dashboardTest();

        //hover to shopping cart and verify go to cart is displayed
        shoppingCartPageObject = new ShoppingCartPageObject(driver);
        shoppingCartPageObject.hoverToShoppingCartMenu_andGoToCart();
        Assert.assertTrue(shoppingCartPageObject.isGoToCartDisplayed());

        //click go to cart
        shoppingCartPageObject.clickGoToCart();

        //verifyTitle
        shoppingCartBlueprint = new ShoppingCartBlueprint(driver);
        String actualShoppingCartTitle = shoppingCartBlueprint.getShoppingCartTitle();
        Assert.assertEquals(actualShoppingCartTitle, "Shopping cart");

        //verify elements are displayed
        Assert.assertTrue(shoppingCartPageObject.isUpdateCartDisplayed());
        Assert.assertTrue(shoppingCartPageObject.isContinueShoppingDisplayed());
        Assert.assertTrue(shoppingCartPageObject.isEstimateShippingDisplayed());

        double actualSum = shoppingCartPageObject.getPricesSum();
        double expectedSum = shoppingCartBlueprint.getTotalAmount();

        Assert.assertEquals(actualSum,expectedSum);
    }

    @Test
    public void EmptyShoppingCartTest() throws InterruptedException {
        //precondition: dashboard test and shopping cart test
        shoppingCartTest();

        //empty shopping cart
        shoppingCartPageObject.emptyShoppingCart();
        Thread.sleep(10000);

        //verify shopping cart is empty
        shoppingCartBlueprint=new ShoppingCartBlueprint(driver);
        int actualNrOfItems3= shoppingCartBlueprint.getNrItemsOnCart();
     //   Thread.sleep(5000);
        Assert.assertEquals(actualNrOfItems3, 0);

      /*  //remove first item
        shoppingCartPageObject.removeItemFromCart(1);
        Thread.sleep(5000);

        //verify nr is decreased by 1
        int actualNrOfItems1= shoppingCartBlueprint.getNrItemsOnCart();
        Thread.sleep(5000);
        Assert.assertEquals(actualNrOfItems1, 2);

        //repeat second time
        shoppingCartPageObject.removeItemFromCart(1);
        Thread.sleep(5000);
        //verify nr is decreased by 1
        int actualNrOfItems2= shoppingCartBlueprint.getNrItemsOnCart();
        Thread.sleep(5000);
        Assert.assertEquals(actualNrOfItems2, 1);

        //repeat third time -> empty liat
        shoppingCartPageObject.removeItemFromCart(1);
        Thread.sleep(5000);
        //verify nr is decreased by 1
        int actualNrOfItems3= shoppingCartBlueprint.getNrItemsOnCart();
        Thread.sleep(5000);
        Assert.assertEquals(actualNrOfItems3, 0);
*/

    }

    public static void setup() {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Arjola");

        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String baseUrl = "https://demo.nopcommerce.com/";
        driver.get(baseUrl);
    }


}
