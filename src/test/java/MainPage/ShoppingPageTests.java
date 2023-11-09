package MainPage;

import Base.BaseTests;
import Pages.ShoppingPage;
import Pages.ProductPage;
import org.testng.*;
import org.testng.annotations.Test;

public class ShoppingPageTests extends BaseTests {

    @Test(groups ="Valid_Scenario")
    public void AddToCartTest(){
        ShoppingPage shoppingPage =ValidLogin();
        String itemName="Sauce Labs Backpack";
        ProductPage productPage= shoppingPage.ChooseItem(itemName);
        Assert.assertEquals(productPage.GetProductName(),itemName);
    }
}
