package demoqa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
