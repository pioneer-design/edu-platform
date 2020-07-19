package cn.com.dhcc.edu.service.impl;

import cn.com.dhcc.edu.pojo.entity.EduCourse;
import cn.com.dhcc.edu.pojo.entity.EduCourseDesc;
import cn.com.dhcc.edu.repository.EduCourseDescRepository;
import cn.com.dhcc.edu.service.EduCourseDescService;
import cn.com.dhcc.edu.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/10 15:37
 */
@Service
public class EduCourseDescServiceImpl implements EduCourseDescService {

    @Autowired
    EduCourseDescRepository courseDescRepository;

    @Override
    public void addCourseDesc(EduCourseDesc courseDesc) {

        courseDescRepository.save(courseDesc);
    }
}
