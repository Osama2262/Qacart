package utils;

import java.util.Properties;
//TODO this class read DATA from PropertiesFILE

 public class ConfigUtils {

    private static Properties properties;
    private static ConfigUtils configutils;


    //CONSTRUCTOR for selecting env
    public ConfigUtils(){
        // Default to "production" if not set
            String env = System.getProperty("env","production");
        if (env == null) {
            env = "production";
        }

        switch (env.toUpperCase()) {
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/config/local.properties");
                break;
            case"PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/config/production.properties");
                break;
            default: throw new RuntimeException("Environment is not supported");
        }

    }


    public String mainURL()
    {
       String props = properties.getProperty("baseURL");
       if(props != null ) return props;
       throw new RuntimeException("The url not found on properties file");
    }


    //this method used to create instance only oneTime
    public static ConfigUtils getInstance()
    {
        if(configutils == null) {
            configutils = new ConfigUtils();
        }
        return configutils;
    }

     //get Prodcation email
    public static String prod_Email()
    {
        String email;
        email = properties.getProperty("email");
        if (email!=null) return email;
        throw new RuntimeException("The email not available on properties files");

    }
    //get Prodcation Password
    public static String prod_Pass()
    {
        String pass;
        pass= properties.getProperty("password");
        if(pass!=null) return pass;
        throw new RuntimeException("The password not available on properties files");
    }

}
