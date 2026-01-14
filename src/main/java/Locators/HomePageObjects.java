package Locators;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObjects extends Browser {
    protected static By logo = By.xpath("//div[@class='logo']");
    protected static By createAccount = By.tagName("a");

    public static WebElement logo() {
        return driver.findElement(logo);
    }

    public static List<WebElement> link() {
        return driver.findElements(createAccount);
    }
}
