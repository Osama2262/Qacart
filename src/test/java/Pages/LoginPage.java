package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //TODO: define locators
    private final By email_field = By.id("email");
    private final By password_field = By.id("password");
    private final By Login_button = By.id("submit");


    //TODO: the login conditions
    //String email_value = "test@223test.com";
    //String password_value = "test@12345678";

    @Step
    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().mainURL());
        return this;
    }

    //TODO: Create a login method
    @Step
    public void login() {

        //TODO:>> To read values from the production.properties File
        driver.findElement(email_field).sendKeys(ConfigUtils.prod_Email());
        driver.findElement(password_field).sendKeys(ConfigUtils.prod_Pass());

        //TODO: (to use the local variables on this class)
/*        driver.findElement(email_field).sendKeys(email_value);
        driver.findElement(password_field).sendKeys(password_value);*/
       driver.findElement(Login_button).click();
    }
}