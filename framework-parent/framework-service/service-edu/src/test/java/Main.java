import util.DateTimeUtils;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/17 9:42
 */
public class Main {
    public static void main(String[] args) {

        List<String> timePointList = new ArrayList<>();
        for (int i = 0; i <=24; i++) {
            if (i % 4 == 0) {
                String timePoint = DateTimeUtils.getPreDateTime(i);
                timePointList.add(timePoint);
                System.out.println(timePoint);

            }
        }
        System.out.println(timePointList.get(0) + "8888");
        System.out.println(timePointList.get(1) + 88888);
    }
}
