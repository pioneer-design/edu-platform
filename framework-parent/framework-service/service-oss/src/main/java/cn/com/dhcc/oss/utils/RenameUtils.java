package cn.com.dhcc.oss.utils;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/6/29 16:43
 */
public class RenameUtils {
    public static String getNewFileName(String fileName) {
        //1.在文件名称里卖弄添加唯一的值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + fileName;

        //2.把文件按照日期进行分类
        // 2020/6/29/01.jpg
        //获取当前日期
        String datePath = new DateTime().toString("yyyy/MM/dd");

        fileName = datePath + "/" + fileName;
        return fileName;
    }
}
