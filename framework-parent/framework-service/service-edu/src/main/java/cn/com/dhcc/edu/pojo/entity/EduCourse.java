package cn.com.dhcc.edu.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <b>课程表</b>
 *
 * @author : WMF
 * @since : 2020/7/8 8:41
 */
@Data
@Entity
@Table(name = "edu_course")
public class EduCourse {


    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //代课教师
    private Long teacherId;
    //分类
    private Long subjectId;
    //上级分类
    private Long subjectParentId;
    //课名称
    private String title;
    //价格
    private BigDecimal price;
    //总课时
    private Integer lessonNum;
    //课时封面路径
    private String cover;
    //销售数量
    private Long buyCount;
    //浏览数量
    private Long viewCount;
    //乐观锁
    private Long version;
    //课时状态（0：未发布；1：已发布）
    private Integer status;
    //逻辑删除(0：未删除；1：已删除)
    private Integer isDeleted;
   //创建时间

   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //修改日期

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
