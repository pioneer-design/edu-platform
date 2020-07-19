package cn.com.dhcc.edu.controller;

import cn.com.dhcc.common.core.R;
import cn.com.dhcc.edu.pojo.entity.FirstSubject;
import cn.com.dhcc.edu.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <b>课程分类控制器</b>
 *
 * @author : WMF
 * @since : 2020/7/2 8:26
 */
@Api(tags = "课程分类控制器")
@RestController
@RequestMapping("edu/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    //添加课程分类
    //获取上传过来文件，把文件进行读取
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
       try {
           //上传过来的 excel 文件
           eduSubjectService.saveSubject(file);
           return R.ok();
       } catch (Exception e) {
           e.printStackTrace();
       }
        return R.error().message("上传失败！");
    }

    //课程分类列表（树形）
    @ApiOperation(value = "获取课程列表")
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        List<FirstSubject> list = null;
        try {
          list = eduSubjectService.getAllSubject();
            return R.ok().data("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("未获得课程分类……");
    }

}
