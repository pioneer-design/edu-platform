package cn.com.dhcc.edu.controller;

import cn.com.dhcc.common.core.R;
import cn.com.dhcc.edu.pojo.entity.EduCourse;
import cn.com.dhcc.edu.pojo.entity.EduCourseDesc;
import cn.com.dhcc.edu.pojo.vo.CourseInfoVo;
import cn.com.dhcc.edu.pojo.vo.EduCourseVo;
import cn.com.dhcc.edu.service.EduCourseDescService;
import cn.com.dhcc.edu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * <b>课程控制器</b>
 *
 * @author : WMF
 * @since : 2020/7/9 9:05
 */
@Api(tags = "课程控制器")
@RestController
@RequestMapping("edu/course")
@CrossOrigin
public class EduCourseController {

    private static final Logger log = LoggerFactory.getLogger(EduCourseController.class);

    @Autowired
    EduCourseService courseService;

    @Autowired
    EduCourseDescService courseDescService;

    @ApiOperation(value = "添加课程信息")
    @PostMapping("/add")
    public R addCourse(@RequestBody EduCourseVo vo) {
        //向课程表中添加数据
        try {
            EduCourse eduCourse = new EduCourse();
            BeanUtils.copyProperties(vo, eduCourse);
            EduCourse course = courseService.addCourse(eduCourse);
            if (course != null) {
                Long cid = course.getId();
                EduCourseDesc courseDesc = new EduCourseDesc();
                courseDesc.setCreateTime(new Date());
                courseDesc.setUpdateTime(new Date());
                courseDesc.setId(cid);
                courseDesc.setDescription(vo.getDescription());
                courseDescService.addCourseDesc(courseDesc);
                return R.ok().message("添加课程成功！").data("courseId", cid);
            }
        } catch (Exception e) {
            log.info("添加课程失败！");
        }
        return R.error();
    }

    //根据 courseId 查询课程的信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseById(@PathVariable Long courseId) {
        CourseInfoVo courseInfoVo = null;
        try {
            courseInfoVo = courseService.findCourseById(courseId);
            if (courseInfoVo != null) {
                return R.ok().data("courseInfoVo", courseInfoVo);
            }
        } catch (Exception e) {
            log.info("查询失败！");
        }
        return R.error().message("查询失败！");
    }

    //修改课程信息
    @PostMapping("updateCourseInfoVo")
    public void updateCourseInfoVo(@RequestBody CourseInfoVo courseInfoVo) {
        try {
            courseService.updateCourseInfo(courseInfoVo);
        } catch (Exception e) {
            log.info("修改失败！" + e.getMessage());
        }
        R.error().message("修改失败！");
    }
}
