package CheckOutInformation;
import Base.BaseTests;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInformationTesting extends BaseTests {

    @Test
    public void ContinueWithEmptyFields()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        var Cartpage= shoppingPage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        CheckoutPage.ClickContinue();
        Assert.assertEquals(CheckoutPage.GetPageTitle(),"Checkout: Your Information");
        Assert.assertEquals(CheckoutPage.GetErrorMsg(),"Error: First Name is required");
    }
    @Test
    public void ContinueWithoutAddpostalCode()
    {
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
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
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
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
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
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
        LoginWith("standard_user","secret_sauce");
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        var Productpage=shoppingPage.ChooseItem("Sauce Labs Fleece Jacket");
        Productpage.AddItemToCart();
        var Cartpage= Productpage.GoToCart();
        var CheckoutPage=Cartpage.ClickOnCheckOut();
        var CartPage2=CheckoutPage.ClickCancel();
        Assert.assertEquals(CartPage2.GetPageTitle(),"Your Cart");
    }
}
