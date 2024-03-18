package Helper;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties properties;

    public static Properties readPropertyFile(String configFilePath) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + configFilePath);
        }
        return properties;
    }
}
