package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    By Checkout= By.id("checkout");
    By Remove=By.xpath("//*[text()='Remove']");
    By CartItem=By.className("cart_item");
    By ContinueShopping=By.id("continue-shopping");



    public CartPage(WebDriver driver)
    {
        super(driver);
    }
    public CheckoutInformation ClickOnCheckOut()
    {if(CountItems()==0){return null;}
        else {
        driver.findElement(Checkout).click();
        return new  CheckoutInformation(driver);}
    }
    public void ClickOnRemove()
    {
        driver.findElement(Remove).click();

    }
    public ShoppingPage ClickOnContinueShopping()
    {
        driver.findElement(ContinueShopping).click();
        return new ShoppingPage(driver);

    }

    public int CountItems()
    {
        List<WebElement> Items;
        Items=driver.findElements(CartItem);
        if(!Items.isEmpty()){
        return Items.size();}
        else
            return 0;

    }
    public void EmptyCart()
    { if(CountItems()!=0){
        for(int i=0;i<=CountItems();i++)
        {
            ClickOnRemove();
        }}
        driver.navigate().back();

    }
}
