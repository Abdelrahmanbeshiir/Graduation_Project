package CheckOutInformation;
import Base.BaseTests;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInformationTesting extends BaseTests {

    @Test(groups ="Valid_Scenario")
    public void ContinueWithEmptyFields()
    {

        ShoppingPage shoppingPage =ValidLogin();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.ClickContinue();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Your Information");
        Assert.assertEquals(CheckoutPage.GetErrorMsg(),"Error: First Name is required");
    }
    @Test
    public void ContinueWithoutAddpostalCode()
    {

        ShoppingPage shoppingPage =ValidLogin();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.SetFirstName("ahmed");
        CheckoutPage.SetLastName("ahmed");
        CheckoutPage.ClickContinue();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Your Information");
        Assert.assertEquals(CheckoutPage.GetErrorMsg(),"Error: Postal Code is required");
    }
    @Test
    public void ContinueWithoutLname()
    {

        ShoppingPage shoppingPage =ValidLogin();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.SetFirstName("ahmed");
        CheckoutPage.ClickContinue();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Your Information");
        Assert.assertEquals(CheckoutPage.GetErrorMsg(),"Error: Last Name is required");
    }
    @Test
    public void ContinueWithValidData()
    {

        ShoppingPage shoppingPage =ValidLogin();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.SetFirstName("ahmed");
        CheckoutPage.SetLastName("ahmed");
        CheckoutPage.SetPostalCode("23156");
        CheckoutPage.ClickContinue();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Overview");
    }
    @Test
    public void ClickingCancel()
    {

        ShoppingPage shoppingPage =ValidLogin();
        var Productpage=shoppingPage.ChooseItem("Sauce Labs Fleece Jacket");
        Productpage.AddItemToCart();
        var Cartpage= Productpage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        var CartPage2=CheckoutPage.ClickCancel();
        Assert.assertEquals(CartPage2.GetPageTitle(),"Your Cart");
    }
}
