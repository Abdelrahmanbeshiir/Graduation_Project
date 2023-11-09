package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MenuBar extends BasePage{


    By Menubar=By.xpath("//* [@class='bm-item-list']");
    By Frame=By.xpath("//* [@class='bm-item-list']");

    public  MenuBar(WebDriver driver){super(driver);}
    By Logout= By.xpath("//* [@id='logout_sidebar_link']");

    public LoggingPage ClickLogout()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(Logout).click();
        return new LoggingPage(driver);

    }

    public  Boolean IsMenuBarDisplayed()

    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver.findElement(Menubar).isEnabled();
    }


}
