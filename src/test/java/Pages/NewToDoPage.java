package Pages;

import Base.BasePage;
import config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

public class NewToDoPage extends BasePage {
    public NewToDoPage(WebDriver driver) {
        super(driver);
    }



    //TODO:Create locators
    private final By Add_button =By.cssSelector("[data-testid=\"add\"]");
    private final By item_f = By.cssSelector("[data-testid=\"new-todo\"]");
    private final By button = By.cssSelector("[data-testid=\"submit-newTask\"]");
    private final By todo_name = By.cssSelector("[data-testid=\"todo-text\"]");



    //TODO: Create click on add button
    @Step
    public NewToDoPage clickOnButton()  {

        driver.findElement(Add_button).click();
        //Thread.sleep(2000);
        return this;
    }

    //TODO: crate a method to enter to do name
    @Step
    public NewToDoPage enterTodoName(String value)   {

        driver.findElement(item_f).sendKeys(value);
        //Thread.sleep(2000);
        return this;
    }


    //TODO: crate a method to click to create todo
    @Step
    public NewToDoPage clickToCreate()   {

        driver.findElement(button).click();
        return this;

    }
    //TODO: crate a method to visit todo page
    @Step
    public NewToDoPage load_NewToDoPage()
    {
        driver.get(ConfigUtils.getInstance().mainURL()+ EndPoint.TODO_PAGE_API_ENDPOINT);
        return this;
    }


    public String getTodoName()
    {
        return driver.findElement(todo_name).getText();
    }


}
