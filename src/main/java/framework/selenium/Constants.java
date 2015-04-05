package framework.selenium;

public class Constants {

    // Timeouts seconds
    public static int TIMEOUT_MIN = 2;
    public static int TIMEOUT_NORMAL = 15;
    public static int TIMEOUT_MAX = 50;

    // Enums constants
    public enum Browsers {
        FIREFOX, CHROME, IE, SAFARI
    }

    /**
     * Enum to get the color code
     */
    public enum ColorCode {
        LIGHTGREEN("color:#c1d953", "rgb(149, 239, 99);"),
        RED("color:#ff44d0", "rgb(255, 133, 129);"),
        ORANGE("color:#73cee5", "rgb(255, 196, 113);"),
        YELLOW("color:#fdc00f", "rgb(249, 236, 117);");

        private String colorCode;
        private String rgb;

        private ColorCode(String colorCode, String rgb) {
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
}
