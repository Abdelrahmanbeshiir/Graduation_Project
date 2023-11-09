package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggingPage extends BasePage{
    By UsernameField= By.id("user-name");
    By PasswordField=By.id("password");
    By LoginButton=By.xpath("//* [@type='submit']");
    By inValidLogin=By.xpath("//div [@class='error-message-container error']");
    public LoggingPage(WebDriver driver)
    {
        super(driver);
    }
    public void SetUserName(String username)
    {
      driver.findElement(UsernameField).sendKeys(username);
    }
    public void SetPassword(String password)
    {
        driver.findElement(PasswordField).sendKeys(password);
    }
    public ShoppingPage ClickLogin()
    {
        driver.findElement(LoginButton).click();
        return new ShoppingPage(driver);
    }
    public String GetInValidLoginMsg()
    {
        return driver.findElement(inValidLogin).getText();
    }
    public Boolean ISLoginButtonDisplayed(){return driver.findElement(UsernameField).isDisplayed();}


}
