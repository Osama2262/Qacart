package API;

import Objects.Task;
import Objects.User;
import config.EndPoint;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import utils.ConfigUtils;
import utils.CookieUtils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.UserUtils.FakerData;

public class TaskAPI {
    public void addTask(String token)
    {
        Task task = new Task("newOne", false);
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.Register();
        Response response =
         given()
                .baseUri(ConfigUtils.getInstance().mainURL())
                .header("Content-Type","application/json")
                .body(task)
                 .auth().oauth2(token)
        .when()
                .post(EndPoint.TASK_API_ENDPOINT)
        .then()
                .log().all().extract().response();
        if(response.statusCode()!= 201)
        {
            throw new RuntimeException(" The Status code is incorrect the currant Code is:["+ response.statusCode()+"]");
        }





    }
}
