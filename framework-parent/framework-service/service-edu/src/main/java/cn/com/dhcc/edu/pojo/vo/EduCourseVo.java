package cn.com.dhcc.edu.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b>课程视图对象</b>
 *
 * @author : WMF
 * @since : 2020/7/9 8:32
 */
@Data
public class EduCourseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //课名称
    private String title;
    //分类
    private Long subjectId;
    //上级分类
    private Long subjectParentId;
    //价格
    private BigDecimal price;
    //总课时
    private Integer lessonNum;
    //课时封面路径
    private String cover;
    //课程简介
    private String description;
}
