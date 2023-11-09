package Base;
import Pages.LoggingPage;
import Pages.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTests {
    public LoggingPage loginPage;
    private WebDriver driver;
    public By MenuIcon= By.xpath("//button [@id='react-burger-menu-btn']");
    private String ValidUserName="standard_user";
    private String ValidPassword="secret_sauce";

    public void LoginWith(String username,String Password)
    {
        loginPage.SetUserName(username);
        loginPage.SetPassword(Password);
    }
    public ShoppingPage ValidLogin()
    {
        loginPage.SetUserName(ValidUserName);
        loginPage.SetPassword(ValidPassword);
        loginPage.ClickLogin();
        return new ShoppingPage(driver);
    }
    public  void ClickOnMenu()
    {
       driver.findElement(MenuIcon).click();
    }

    @BeforeClass
    public void SetUp()
    {
        driver=new EdgeDriver();
         GoHome();
         loginPage=new LoggingPage(driver);
         driver.manage().window().maximize();
    }

    @BeforeMethod
    public void GoHome(){
        try {
            Thread.sleep(Duration.ofMillis(50));
        }catch (Exception e){}
        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass
    public void Quit()
    {
     driver.quit();
    }

}
