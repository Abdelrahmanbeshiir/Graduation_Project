package CheckoutOverView;

import Base.BaseTests;
import Pages.BasePage;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverViewTest extends BaseTests {
    @Test(groups ="Valid_Scenario")
    public void TestClickingFinish()
    {
        ShoppingPage shoppingPage =ValidLogin();
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
        ShoppingPage shoppingPage =ValidLogin();
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
