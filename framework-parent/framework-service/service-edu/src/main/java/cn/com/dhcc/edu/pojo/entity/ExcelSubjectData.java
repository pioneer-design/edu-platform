package cn.com.dhcc.edu.pojo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <b>课程分类级别</b>
 *
 * @author : WMF
 * @since : 2020/7/2 8:36
 */
@Data
public class ExcelSubjectData {
    @ExcelProperty(index = 0)
    private String firstSubjectName;

    @ExcelProperty(index = 1)
    private String secondSubjectName;
}
