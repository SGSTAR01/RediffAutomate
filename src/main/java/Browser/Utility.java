package Browser;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Utility {
    public static String properties(String data) {
        String propertiesData = null;
        try {
            File filePath = new File("src/main/resources/configuration.properties");
            FileReader reader = new FileReader(filePath);
            Properties p = new Properties();
            p.load(reader);
            propertiesData = p.getProperty(data);

        } catch (Exception e) {
            System.out.println("Properties: " + e);
        }
        return propertiesData;
    }
}
