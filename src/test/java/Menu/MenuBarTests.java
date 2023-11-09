package Menu;
import Base.BaseTests;
import Pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuBarTests extends BaseTests{
    @Test
    public void TestMenuBar()
    {
       ShoppingPage shoppingPage= ValidLogin();
       var Menu=shoppingPage.ClickOnMenu();
      Assert.assertTrue(Menu.IsMenuBarDisplayed());


    }
    @Test
    public void TestLogout()
    {
        ShoppingPage shoppingPage= ValidLogin();
         var Menu=shoppingPage.ClickOnMenu();
        var page=Menu.ClickLogout();
        Assert.assertTrue(page.ISLoginButtonDisplayed());



    }


}
