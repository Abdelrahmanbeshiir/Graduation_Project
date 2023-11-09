package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverView extends BasePage {
    By CancelButton= By.id("cancel");
    By FinishButton=By.id("finish");
    public CheckOutOverView(WebDriver driver)
    {
        super(driver);
    }
    public CheckOutComplete ClickFinish()
    {
        driver.findElement(FinishButton).click();
        return new CheckOutComplete(driver);
    }
    public ShoppingPage ClickCancel()
    {
        driver.findElement(CancelButton).click();
        return new ShoppingPage(driver);
    }
}
