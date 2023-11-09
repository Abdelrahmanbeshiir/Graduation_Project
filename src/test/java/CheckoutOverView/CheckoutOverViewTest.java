package CheckoutOverView;

import Base.BaseTests;
import Pages.BasePage;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverViewTest extends BaseTests {
    @Test
    public void TestClickingFinish()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        shoppingPage.GoToCart().EmptyCart();
        var Productpage=shoppingPage.ChooseItem("Sauce Labs Fleece Jacket");
        Productpage.AddItemToCart();
        var Cartpage= Productpage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.SetFirstName("ahmed");
        CheckoutPage.SetLastName("ahmed");
        CheckoutPage.SetPostalCode("23156");
        var CheckoutOverViewPage=CheckoutPage.ClickContinue();
        var CheckoutCompletePage=CheckoutOverViewPage.ClickFinish();
        Assert.assertEquals(CheckoutCompletePage.GetPageTitle(),"Checkout: Complete!");
    }
    @Test
    public void TestClickingCancel()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        var Productpage=shoppingPage.ChooseItem("Sauce Labs Fleece Jacket");
        Productpage.AddItemToCart();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.SetFirstName("ahmed");
        CheckoutPage.SetLastName("ahmed");
        CheckoutPage.SetPostalCode("23156");
        var CheckoutOverViewPage=CheckoutPage.ClickContinue();
        var Page=CheckoutOverViewPage.ClickCancel();
        Assert.assertEquals(Page.GetPageTitle(),"Products");
    }
}
