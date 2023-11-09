package CheckoutComplete;

import Base.BaseTests;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutCompletePageTest extends BaseTests {
    @Test
    public void TestBackToHome()
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
        var CheckoutCompletePage=CheckoutOverViewPage.ClickFinish();
        Assert.assertEquals(CheckoutCompletePage.ClickBacktoHome().GetPageTitle(),"Products");
    }
    @Test
    public void TestSuccessfulOrderMsg()
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
        var CheckoutCompletePage=CheckoutOverViewPage.ClickFinish();
        Assert.assertEquals(CheckoutCompletePage.CheckSuccessfulOrder(),"Thank you for your order!");
    }

}
