package utils;

import java.io.*;
import java.util.Properties;
//TODO: This method try to get 'filePATH' and loaded to user >> Tobe Able to read the 'PropertiesFILE'
 public class PropertiesUtils {
    public static Properties loadProperties (String FilePath){
        File file = new File(FilePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found ");
        } catch (IOException e){
            throw new RuntimeException("Error while loading");
        }
    }
}
