package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage extends BasePage {
    public By MenuIcon= By.xpath("//button [@id='react-burger-menu-btn']");
    By AppLogo= By.className("app_logo");
    By Title=By.className("title");
    public ShoppingPage(WebDriver driver)
    {super(driver);}

    public Boolean CheckLoginSuccessfully()
    {
        return driver.findElement(AppLogo).isDisplayed();
    }
    public ProductPage ChooseItem(String s)
    {

        driver.findElement(By.xpath("//*[text()='"+s+"']")).click();
        return new ProductPage(driver);
    }
    public CartPage GoToCart()
    {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }
    public String GetPageTitle()
    {
        return driver.findElement(Title).getText();
    }
    public  MenuBar ClickOnMenu()
    {
        driver.findElement(MenuIcon).click();
        return new MenuBar(driver);
    }

}
