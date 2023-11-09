package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformation extends BasePage{
    By FirstNameField = By.id("first-name");
    By LastNameField =By.id("last-name");
    By PostalCodeField =By.id("postal-code");
    By ContinueButton =By.id("continue");
    By CancelButton=By.id("cancel");
    By ErrorMsg=By.xpath("//* [@class='error-message-container error']");
    WebElement UserFname=driver.findElement(FirstNameField);
    WebElement UserLname=driver.findElement(LastNameField);
    WebElement PostalCode=driver.findElement(PostalCodeField);
    public CheckoutInformation(WebDriver driver)
    {
        super(driver);
    }
    public void SetFirstName(String Fname) {SendText(UserFname,Fname);}
    public void SetLastName(String Lname) {SendText(UserLname,Lname);}
    public void SetPostalCode(String Postal) {SendText(PostalCode,Postal);}

    public CheckOutOverView ClickContinue()
    {driver.findElement(ContinueButton).click();
        return new CheckOutOverView(driver);}

    public CartPage ClickCancel()
    {driver.findElement(CancelButton).click();
        return new CartPage(driver);}
    public String GetErrorMsg()
    {
        return driver.findElement(ErrorMsg).getText();
    }
}
