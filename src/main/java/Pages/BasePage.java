package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected By PageTitle=By.className("title");
    public String GetPageTitle()
    {
        return driver.findElement(PageTitle).getText();
    }
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void SendText(WebElement element,String string){
        element.sendKeys(string);
    }





}
