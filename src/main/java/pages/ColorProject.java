package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

/**
 * Created by Silvia Coca on 29/03/2015.
 */
public enum ColorProject {

    LIGHTGREEN("color:#c1d953", "rgb(149, 239, 99);"),
    RED("color:#ff44d0", "rgb(255, 133, 129);"),
    ORANGE("color:#73cee5", "rgb(255, 196, 113);"),
    YELLOW("color:#fdc00f", "rgb(249, 236, 117);");

    private String colorCode;
    private String rgb;

    private ColorProject(String colorCode, String rgb) {
        this.colorCode = colorCode;
        this.rgb = rgb;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getRGB() {
        return rgb;
    }

}
