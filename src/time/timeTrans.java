package time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeTrans {

    @Test
    public void time(){
        long timestamp = 1705461223817L;

        // 将时间戳转换为日期对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date date = new Date(timestamp);
        // 将日期转换为字符串
        String formattedDate = dateFormat.format(date);

        // 打印日期
        System.out.println(formattedDate);
    }
}
