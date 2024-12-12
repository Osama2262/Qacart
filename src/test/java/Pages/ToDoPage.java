package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToDoPage extends BasePage {

    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    //TODO: define locators
    private final By welcomeMessage = By.cssSelector("[data-testid=\"welcome\"]");
    private final By NoTodos = By.cssSelector("[data-testid=\"no-todos\"]");
    private final By DeleteIcon = By.cssSelector("[data-testid=\"delete\"]");
    private  final By logout_button = By.xpath("//span[contains(.,'Logout')]");


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
    @Step
    public void logout_button(){
        driver.findElement(logout_button).click();
    }


    //TODO: Create a Delete method
    @Step
    public void deleteToDo()  {
        driver.findElement(DeleteIcon).click();
    }

    //TODO: get_CurrentURL
    @Step
    public String  get_CurrentURL()
    {
        return driver.getCurrentUrl();
    }
}
