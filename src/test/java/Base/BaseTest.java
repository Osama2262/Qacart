package Base;

import Factory.DriverFactory;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.CookieUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;


public class BaseTest {
    protected ThreadLocal<WebDriver> driver =new ThreadLocal<>();
    public WebDriver getDriver() {
        return this.driver.get();
    }
    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }



    @BeforeMethod
    public void setup()
    {

        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void shutdown(ITestResult result) throws InterruptedException {
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
        takeScreenShot(String.valueOf(destFile));
        getDriver().quit();
        Thread.sleep(600);
    }

    public void takeScreenShot(String destFile)
    {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(destFile));
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot", is);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void injectCookies(List<Cookie> restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie> cookies = CookieUtils.convertRestCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie: cookies)
        {
            getDriver().manage().addCookie(cookie);
        }
    }

}
