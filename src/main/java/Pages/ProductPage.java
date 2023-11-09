package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    By AddToCartButton=By.xpath("//*[text()='Add to cart']");
    By RemoveFromCart=By.xpath("//*[text()='Remove']");
    By ProductName=By.xpath("//div[@class='inventory_details_name large_size']");
    By BackToProducts=By.xpath("//* [@name='back-to-products']");
    public ProductPage(WebDriver driver) {super(driver);}
    public void AddItemToCart()
    {
        driver.findElement(AddToCartButton).click();

    }
    public Boolean CheckIfAdded()
    {
        return driver.findElement(RemoveFromCart).isDisplayed();

    }
    public Boolean CheckIfRemoved()
    {
        return driver.findElement(AddToCartButton).isDisplayed();

    }
    public String GetProductName()
    {
        return driver.findElement(ProductName).getText();
    }
    public void RemoveItemFromCart()
    {
        driver.findElement(RemoveFromCart).click();
    }
    public CartPage GoToCart()
    {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }
    public ShoppingPage ClickOnBackToProduct()
    {
        driver.findElement(BackToProducts).click();
        return new ShoppingPage(driver);
    }
}
