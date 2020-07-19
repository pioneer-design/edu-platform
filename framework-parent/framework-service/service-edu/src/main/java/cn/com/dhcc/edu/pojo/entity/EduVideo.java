package cn.com.dhcc.edu.pojo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <b>课程小节</b>
 *
 * @author : WMF
 * @since : 2020/7/8 8:45
 */
@Data
@Entity
@Table(name = "edu_video")
public class EduVideo {

    //课程小节ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //课程ID
    private Long courseId;

    //章节ID
    private Long chapterId;

    //小节名称
    private String title;

    //视频来源ID
    private Long videoSourceId;

    private String videoOrigin;
}
