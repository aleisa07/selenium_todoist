package framework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by CARLEDRISS on 3/25/2015.
 */
public class Environment {

    private static Environment instance;
    private Properties properties;

    private Environment() {
        properties = new Properties();
        File file = new File("gradle.properties");
        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    public String getEnvSetting(String envSetting) {
        String setting = System.getProperty(envSetting);
        if (setting == null) {
            setting = properties.getProperty(envSetting);
        }
        return setting;
    }

    public String getBrowser() {
        return getEnvSetting("browser");
    }

    public String getUserName() {
        return getEnvSetting("username");
    }

    public String getUserPassword() {
        return getEnvSetting("userpassword");
    }

    public static void main(String[] args) {
        System.out.println(Environment.getInstance().getEnvSetting("todoist.user.name"));
    }



}
