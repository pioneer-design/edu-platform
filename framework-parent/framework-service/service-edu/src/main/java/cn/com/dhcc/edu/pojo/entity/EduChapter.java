package cn.com.dhcc.edu.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <b>课程章节表</b>
 *
 * @author : WMF
 * @since : 2020/7/8 8:43
 */
@Data
@Entity
@Table(name = "edu_chapter")
public class EduChapter {

    //课程章节ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //课程ID
    private Long courseId;

    //章节名称
    private String title;

    //排序
    private Integer sort;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
