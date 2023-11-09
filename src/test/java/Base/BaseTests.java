package Base;
import Pages.Home_Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTests {
    public Home_Login_Page loginPage;
    public WebDriver driver;
    public void LoginWith(String username,String Password)
    {
        loginPage.SetUserName(username);
        loginPage.SetPassword(Password);
    }

    @BeforeTest
    public void SetUp()
    {
         driver=new EdgeDriver();
         GoHome();
         loginPage=new Home_Login_Page(driver);
         driver.manage().window().maximize();
    }
    @BeforeMethod
    public void GoHome(){
        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass
    public void Quit()
    {
       driver.quit();
    }
}
