package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutComplete extends BasePage {

    By ThankYouMsg= By.className("complete-header");
    public CheckOutComplete(WebDriver driver){super(driver);}
    public String CheckSuccessfulOrder()
    {
        return driver.findElement(ThankYouMsg).getText();
    }
    public ShoppingPage ClickBacktoHome()
    {
        driver.findElement(By.id("back-to-products")).click();
        return new ShoppingPage(driver);
    }

}
