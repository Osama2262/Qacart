package Testcases;

import API.RegisterAPI;
import Base.BaseTest;
import Pages.LoginPage;
import Pages.NewToDoPage;
import Pages.ToDoPage;
import config.EndPoint;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigUtils;

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
    @Test(description =" User are able to logout from his account")
    public void ableToLogOut()  {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        RegisterAPI registerAPI =new RegisterAPI();
        registerAPI.Register();
        injectCookies(registerAPI.getRestAssuredCookies());
        NewToDoPage newToDoPage = new NewToDoPage(getDriver());
        newToDoPage.load_NewToDoPage();
        ToDoPage toDoPage = new ToDoPage(getDriver());
        toDoPage.logout_button();
        String current = toDoPage.get_CurrentURL();
        Assert.assertEquals(current, ConfigUtils.getInstance().mainURL() +"/login");
    }
}
