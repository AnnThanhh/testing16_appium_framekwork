package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Logger logger = LogManager.getLogger(ConfigManager.class);
    private static Properties properties = new Properties();

    public static void loadProperties() {
        try(InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("configure.properties")) {
            if(input == null) {
                logger.warn("configure.properties file not found");
                return;
            }
            properties.load(input);
            logger.info("Properties loaded successfully");
        } catch (IOException e) {
            logger.error("Error loading properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}