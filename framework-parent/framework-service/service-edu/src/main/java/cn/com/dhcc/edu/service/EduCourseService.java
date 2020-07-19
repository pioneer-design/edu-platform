package cn.com.dhcc.edu.service;

import cn.com.dhcc.edu.pojo.entity.EduCourse;
import cn.com.dhcc.edu.pojo.vo.CourseInfoVo;

import java.util.Optional;

/**
 * <b>课程服务类</b>
 *
 * @author : WMF
 * @since : 2020/7/9 9:07
 */
public interface EduCourseService {
    EduCourse addCourse(EduCourse eduCourse);

    CourseInfoVo findCourseById(Long courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);
}
