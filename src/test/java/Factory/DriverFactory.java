package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    WebDriver driver;

    public WebDriver initializeDriver() {

        String browser = System.setProperty("browser","CHROME");
        if (browser == null)// to set a default value & avoid any error when i run it with intellij IDE
        {
            browser = "CHROME";
        }
        switch (browser.toUpperCase())
        {
            case"CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case"FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case"EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("This browser not supported");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(6));
        return driver;
    }
}

