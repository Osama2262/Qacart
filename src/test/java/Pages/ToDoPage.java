package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigUtils;

public class ToDoPage extends BasePage {

    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    //TODO: define locators
    private final By welcomeMessage = By.cssSelector("[data-testid=\"welcome\"]");
    private final By NoTodos = By.cssSelector("[data-testid=\"no-todos\"]");
    private final By DeleteIcon = By.cssSelector("[data-testid=\"delete\"]");


    //TODO: Create a checkWelcome method
    @Step
    public boolean checkWelcome() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }
    

    //TODO: Create a NoAvailableTodos method
    @Step
    public boolean NoAvailableTodos()   {
        return driver.findElement(NoTodos).isDisplayed();
    }




    //TODO: Create a Delete method
    @Step
    public void deleteToDo() throws InterruptedException {
        driver.findElement(DeleteIcon).click();
       // Thread.sleep(2000);

    }
    

}