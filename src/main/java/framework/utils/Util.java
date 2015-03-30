package framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by carlos_gonzales on 06-03-15.
 */
public class Util {
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        return simpleDateFormat.format(date);
    }




}
