package API;

import Objects.User;
import config.EndPoint;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import utils.ConfigUtils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.UserUtils.FakerData;

public class RegisterAPI {
    private static List<Cookie> restAssuredCookies;
    private  String accessToken;
    private static String userId;
    public void resetCookies()
    {
        restAssuredCookies.clear();
    }
    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }
    public String getAccessToken() {
        return this.accessToken;
    }
    public String getUserId(){
        return userId;
    }



    public void Register()
    {
        User user = FakerData();

        Response response =
        given()
                .baseUri(ConfigUtils.getInstance().mainURL())
                .header("Content-Type","application/json")
                .body(user)
        .when()
                 .post(EndPoint.REGISTER_API_ENDPOINT)
        .then()
                 .log()
                 .all()
                 .extract()
                 .response();

            accessToken = response.path("access_token");
            restAssuredCookies = response.getDetailedCookies().asList();
            userId =response.path("userID");
         if(response.statusCode()!= 201)
         {
             throw new RuntimeException(" The Status code is incorrect the currant Code is:["+ response.statusCode()+"]");
         }
    }
}
