package TestCase;

import Browser.Browser;
import Pages.HomePage;


public class Demo {
    public static void main(String[] args) {

        Browser.openBrowser();
        Browser.title("Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
        Browser.screenShot("HomePage");
        HomePage.click("Create Account");
        Browser.closeBrowser();
    }
}
