package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/19 9:57
 */
public class DateTimeUtils {

    /**
     * 获得前一天的时间
     * @return
     */
    public static String getPreDateTime(Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, -hour);
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
