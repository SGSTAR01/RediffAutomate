package Browser;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void openBrowser() {
        try {
            String choice = Utility.properties("browser");
            if (choice.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (choice.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else if (choice.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else {
                System.out.println("Requested browser not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void title(String title) {
        try {
            driver.get(Utility.properties("url"));
            driver.manage().window().maximize();
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.titleIs(title));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void screenShot(String name) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshot/" + name + ".png");
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
