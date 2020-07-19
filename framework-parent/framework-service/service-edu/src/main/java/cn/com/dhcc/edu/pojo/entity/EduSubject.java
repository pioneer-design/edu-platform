package cn.com.dhcc.edu.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <b>课程分类实体类</b>
 *
 * @author : WMF
 * @since : 2020/6/30 9:53
 */
@Data
@Entity
@Table(name = "edu_subject")
public class EduSubject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long parentId;
    private int sort;
    private Date createTime;
    private Date updateTime;

    public EduSubject() {}
    public EduSubject(Long parentId, String title, Date createTime, Date updateTime) {
        this.title = title;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
