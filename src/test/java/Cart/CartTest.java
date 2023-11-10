package Cart;

import Base.BaseTests;

import Pages.ShoppingPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTests {
    @Test(priority = 1)
    public void TestsAddItemsToCart()
    {
        ShoppingPage shoppingPage =ValidLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.AddItemToCart();
        productPage.ClickOnBackToProduct();
        String item2Name="Sauce Labs Bike Light";
        ProductPage product2Page= shoppingPage.ChooseItem(item2Name);
        product2Page.AddItemToCart();
        var CartPage=productPage.GoToCart();
        System.out.println(CartPage.CountItems());
        Assert.assertEquals(CartPage.CountItems(),2,"Counting is wrong");
    }
SoftAssert softAssert=new SoftAssert();
    @Test(priority = 2)
    public void TestsRemoveItemFromCart()
    {

        ShoppingPage shoppingPage =ValidLogin();
        shoppingPage.GoToCart().EmptyCart();
        String itemName="Sauce Labs Onesie";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.AddItemToCart();
        var mainPage2=productPage.ClickOnBackToProduct();
        String item2Name="Sauce Labs Fleece Jacket";
        ProductPage product2Page=mainPage2.ChooseItem(item2Name);
        product2Page.AddItemToCart();
        var CartPage=productPage.GoToCart();
        CartPage.ClickOnRemove();
        System.out.println(CartPage.CountItems());
        softAssert.assertEquals(CartPage.CountItems(),1,"Counting is wrong");


    }
    @Test(priority = 3)
    public void TestCheckoutFromCart()
    {try{
        ShoppingPage shoppingPage =ValidLogin();
        var itemPage=shoppingPage.ChooseItem("Sauce Labs Fleece Jacket");
        itemPage.AddItemToCart();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Your Information");}catch (Exception e){
        System.out.println("Choose item First to Checkup");
    }
    }
    @Test(priority = 4)
    public void TestBackFromCart()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        var Cartpage= shoppingPage.GoToCart();
        var ShoppingPage=Cartpage.ClickOnContinueShopping();
        Assert.assertEquals(ShoppingPage.GetPageTitle(),"Products");
    }


}
