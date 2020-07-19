package cn.com.dhcc.edu.service.impl;

import cn.com.dhcc.edu.pojo.entity.EduCourse;
import cn.com.dhcc.edu.pojo.entity.EduCourseDesc;
import cn.com.dhcc.edu.pojo.vo.CourseInfoVo;
import cn.com.dhcc.edu.repository.EduCourseDescRepository;
import cn.com.dhcc.edu.repository.EduCourseRepository;
import cn.com.dhcc.edu.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * <b>课程服务类实现类</b>
 *
 * @author : WMF
 * @since : 2020/7/9 9:08
 */
@Service
public class EduCourseServiceImpl implements EduCourseService {

    @Autowired
    EduCourseRepository courseRepository;

    @Autowired
    EduCourseDescRepository courseDescRepository;

    @Override
    public EduCourse addCourse(EduCourse eduCourse) {
        eduCourse.setCreateTime(new Date());
        eduCourse.setUpdateTime(new Date());
        return courseRepository.save(eduCourse);
    }

    @Override
    public CourseInfoVo findCourseById(Long courseId) {
        //查询课程信息
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        EduCourse course = courseRepository.findAllById(courseId);
        EduCourseDesc courseDesc = courseDescRepository.findAllById(courseId);
        BeanUtils.copyProperties(course, courseInfoVo);
        courseInfoVo.setDescription(courseDesc.getDescription());
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, course);
        courseRepository.save(course);
        EduCourseDesc courseDesc = new EduCourseDesc();
        courseDesc.setDescription(courseInfoVo.getDescription());
        courseDescRepository.save(courseDesc);
    }

}
