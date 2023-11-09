package ProductPage;
import Base.BaseTests;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPageTests extends BaseTests {

    @Test(groups = "MainSenario")
    public void TestAddToCart()
    {
        loginPage.SetUserName("standard_user");
        loginPage.SetPassword("secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.AddItemToCart();
        Assert.assertTrue(productPage.CheckIfAdded(),itemName+"System didn't added item to cart");
    }
    @Test
    public void TestRemoveFromCart()
    {
        loginPage.SetUserName("standard_user");
        loginPage.SetPassword("secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.RemoveItemFromCart();
        Assert.assertTrue(productPage.CheckIfRemoved(),itemName+"System didn't Remove item from cart");
    }
    @Test
    public void TestBackToProducts()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        String itemName="Sauce Labs Onesie";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        var Page=productPage.ClickOnBackToProduct();
        Assert.assertEquals(Page.GetPageTitle(),"Products","Not in Products Page");
    }
}
