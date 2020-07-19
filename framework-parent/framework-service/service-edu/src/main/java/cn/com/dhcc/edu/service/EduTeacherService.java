package cn.com.dhcc.edu.service;

import cn.com.dhcc.edu.pojo.entity.Teacher;
import cn.com.dhcc.edu.pojo.vo.IPage;
import cn.com.dhcc.edu.pojo.vo.QueryResult;
import cn.com.dhcc.edu.pojo.vo.TeacherVo;

import java.util.List;

/**
 * <b>教师服务类</b>
 *
 * @author testjava
 * @since 2020-06-21
 */
public interface EduTeacherService {

    List<Teacher> list(Object o);

    void removeById(Long id);

    QueryResult<Teacher> findAll(IPage<Teacher> pageVo);

    QueryResult<Teacher> findTeacherByCondition(IPage<Teacher> pageVo, TeacherVo teacherQuery);

    void saveTeacher(Teacher nextTeacher);

    Teacher findTeacherById(Long id);

    void updateTeacher(Teacher currentTeacher);
}
