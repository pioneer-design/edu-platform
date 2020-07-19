package cn.com.dhcc.edu.controller;


import cn.com.dhcc.common.core.R;
import cn.com.dhcc.edu.pojo.entity.Teacher;
import cn.com.dhcc.edu.pojo.vo.IPage;
import cn.com.dhcc.edu.pojo.vo.QueryResult;
import cn.com.dhcc.edu.pojo.vo.TeacherVo;
import cn.com.dhcc.edu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>前端控制器</b>
 *
 * @author testjava
 * @since 2020-06-21
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher() {
        List<Teacher> teacherList = null;
        try {
            teacherList = eduTeacherService.list(null);
            if (teacherList != null && teacherList.size() > 0) {
                return R.ok().data("items", teacherList);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("查询失败");
    }

    @ApiOperation(value = "根据 ID 查询教师信息")
    @GetMapping("findOne/{id}")
    public R findOneTeacherById(@PathVariable Long id) {
        Teacher teacher = null;
        try {
            teacher = eduTeacherService.findTeacherById(id);
            if (teacher != null) {
                return R.ok().data("teacher", teacher);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("查询失败");
    }

    @ApiOperation(value = "逻辑删除讲师")
    @PostMapping("delete/{id}")
    public R removeTeacher(
           @ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable Long id) {
       try {
           eduTeacherService.removeById(id);
           return R.ok();
       }catch (Exception e) {
           e.printStackTrace();
       }
        return R.error();
    }

    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@ApiParam(name = "current", value = "当前页码") @PathVariable Integer current,
                             @ApiParam(name = "limit", value = "每页的记录数") @PathVariable Integer limit) {
        QueryResult<Teacher> res = null;
        IPage<Teacher> pageVO = new IPage<Teacher>(current, limit);
        try {
            res = eduTeacherService.findAll(pageVO);
            if (res != null) {
                return R.ok().data("total",res.getTotal()).data("rows",res.getList());
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return R.error();
    }

    @ApiOperation(value = "条件查询带分页")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@ApiParam(name = "current", value = "当前页码") @PathVariable Integer current,
                                  @ApiParam(name = "limit", value = "每页的记录数") @PathVariable Integer limit,
                                  @RequestBody TeacherVo teacherVo) {
        QueryResult<Teacher> res = null;
        IPage<Teacher> pageVO = new IPage<>(current, limit);
        try {
            res = eduTeacherService.findTeacherByCondition(pageVO, teacherVo);
            if (res != null) {
                return R.ok().data("total",res.getTotal()).data("rows", res.getList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("查询失败");
    }

    @ApiOperation(value = "添加新的教师信息")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody Teacher nextTeacher) {
        try {
            eduTeacherService.saveTeacher(nextTeacher);
            return R.ok().message("添加新教师成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("添加新教师失败！");
    }

    @ApiOperation(value = "修改教师信息")
    @PostMapping(value = "updateTeacher")
    public R updateTeacher(@RequestBody Teacher currentTeacher) {
        Teacher targetTeacher = null;
        try {
            //先查询目标对象
            targetTeacher = eduTeacherService.findTeacherById(currentTeacher.getId());
            if (targetTeacher != null) {
                eduTeacherService.updateTeacher(currentTeacher);
                return R.ok();
            }
        } catch (Exception e) {
            //自定义异常
            e.printStackTrace();
        }
        return R.error().message("保存失败!");
    }
}

