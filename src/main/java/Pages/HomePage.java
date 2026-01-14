package Pages;

import Locators.HomePageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends HomePageObjects {

    public static void click(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
            List<WebElement> elements = HomePageObjects.link();
            for (int i = 0; i <= elements.size(); i++) {
                if (elements.get(i).getText().equalsIgnoreCase(text)) {
                    elements.get(i).click();
                    break;
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
