package MainPage;

import Base.BaseTests;
import Pages.ShoppingPage;
import Pages.ProductPage;
import org.testng.*;
import org.testng.annotations.Test;

public class ShoppingPageTests extends BaseTests {
    ShoppingPage shoppingPage;
    @Test(groups = "MainSenario")
    public void AddToCartTest(){
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        Assert.assertEquals(productPage.GetProductName(),itemName);
    }
}
