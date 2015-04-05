package framework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Carlos Gonzales on 3/25/2015.
 */
public class ReadSetting {

    private static ReadSetting instance;
    private Properties properties;

    private ReadSetting() {
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

    public static ReadSetting getInstance() {
        if (instance == null) {
            instance = new ReadSetting();
        }
        return instance;
    }

    public String getEnvSetting(String setting) {
        String envSetting = System.getProperty(setting);
        if (setting == null) {
            envSetting = properties.getProperty(setting);
        }
        return envSetting;
    }


    public static void main(String[] args) {
        System.out.println(ReadSetting.getInstance().getEnvSetting("browser"));
    }



}
