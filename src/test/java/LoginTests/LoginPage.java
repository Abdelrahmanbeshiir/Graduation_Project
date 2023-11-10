package LoginTests;
import Base.LoginDataProvider;
import Pages.*;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseTests {


    @Test(dataProviderClass = LoginDataProvider.class,dataProvider = "ValidTestData(username,password)")
    public void TestLogin(String username,String password)
    {   LoginWith(username,password);
        ShoppingPage shoppingPage =loginPage.ClickLogin();
        Assert.assertTrue(shoppingPage.CheckLoginSuccessfully());
    }

    @Test
    public void TestINValidLogin() {
        LoginWith("standard_user", "1236555a");
        loginPage.ClickLogin();
        Assert.assertEquals(loginPage.GetInValidLoginMsg(), "Epic sadface: Username and password do not match any user in this service", "different msg1");
    }
    @Test
    public void TestINValidLogin2()
    {
         LoginWith("locked_out_user","secret_sauce");
         loginPage.ClickLogin();
        System.out.println(loginPage.GetInValidLoginMsg());
        Assert.assertEquals(loginPage.GetInValidLoginMsg(),"Epic sadface: Sorry, this user has been locked out.","different msg1");
    }
}
