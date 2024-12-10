package Testcases;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ToDoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Auth Features")
public class LoginTest extends BaseTest {
    @Story("Login function")
    @Test  (description ="User are able to login with a valid values")
    public void UserCanLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        ToDoPage toDoPage = new ToDoPage(getDriver());

        loginPage.load().login();

        Assert.assertTrue(toDoPage.checkWelcome());
        Assert.assertTrue(toDoPage.NoAvailableTodos());
    }
}
