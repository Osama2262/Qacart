import API.RegisterAPI;

public class tempFile
{
    public static void main(String[] args) {
        RegisterAPI register= new RegisterAPI();
        register.Register();
        System.out.println(register.getAccessToken());
        System.out.println(register.getRestAssuredCookies());
        System.out.println(register.getUserId());


    }
}
