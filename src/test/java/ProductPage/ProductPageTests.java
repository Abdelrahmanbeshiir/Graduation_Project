package ProductPage;
import Base.BaseTests;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPageTests extends BaseTests {

    @Test
    public void TestAddToCart()
    {
        ShoppingPage shoppingPage =ValidLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.AddItemToCart();
        Assert.assertTrue(productPage.CheckIfAdded(),itemName+"System didn't added item to cart");
    }
    @Test
    public void TestRemoveFromCart()
    {
        ShoppingPage shoppingPage =ValidLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        productPage.RemoveItemFromCart();
        Assert.assertTrue(productPage.CheckIfRemoved(),itemName+"System didn't Remove item from cart");
    }
    @Test
    public void TestBackToProducts()
    {

        ShoppingPage shoppingPage =ValidLogin();
        String itemName="Sauce Labs Onesie";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        var Page=productPage.ClickOnBackToProduct();
        Assert.assertEquals(Page.GetPageTitle(),"Products","Not in Products Page");
    }
}
