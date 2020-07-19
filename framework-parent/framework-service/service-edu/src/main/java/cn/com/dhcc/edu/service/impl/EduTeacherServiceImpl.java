package cn.com.dhcc.edu.service.impl;

import cn.com.dhcc.edu.pojo.entity.Teacher;
import cn.com.dhcc.edu.pojo.vo.IPage;
import cn.com.dhcc.edu.pojo.vo.QueryResult;
import cn.com.dhcc.edu.pojo.vo.TeacherVo;
import cn.com.dhcc.edu.repository.EduTeacherRepository;
import cn.com.dhcc.edu.service.EduTeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <b>教师业务实现类<b/>
 *
 * @author testjava
 * @since 2020-06-21
 */
@Service
public class EduTeacherServiceImpl implements EduTeacherService {

    @Autowired
    private EduTeacherRepository eduTeacherRepository;

    @Override
    public List<Teacher> list(Object o) {
        return eduTeacherRepository.findAll();
    }

    @Override
    public void removeById(Long id) {
        eduTeacherRepository.deleteById(id);
    }

    @Override
    public QueryResult<Teacher> findAll(IPage<Teacher> pageVo) {
        Pageable pageRequest = PageRequest.of(pageVo.getPageIndex() - 1,
                pageVo.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        Page<Teacher> page = eduTeacherRepository.findAll(pageRequest);
        QueryResult<Teacher> queryResult = new QueryResult<>();
        queryResult.setList(page.getContent());
        queryResult.setTotal(page.getTotalElements());
        return queryResult;
    }

    @Override
    public QueryResult<Teacher> findTeacherByCondition(IPage<Teacher> pageVo, TeacherVo teacherQuery) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherQuery, teacher);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("level", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("createTime", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("updateTime", ExampleMatcher.GenericPropertyMatchers.contains());

        Example example = Example.of(teacher, matcher);
        Pageable pageRequest = PageRequest.of(pageVo.getPageIndex() - 1,
                pageVo.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        Page<Teacher> page = eduTeacherRepository.findAll(example, pageRequest);
        QueryResult<Teacher> queryResult = new QueryResult<>();
        queryResult.setList(page.getContent());
        queryResult.setTotal(page.getTotalElements());
        return queryResult;
    }

    @Override
    public void saveTeacher(Teacher nextTeacher) {
        nextTeacher.setBegin(new Date());
        eduTeacherRepository.save(nextTeacher);
    }


    @Override
    public Teacher findTeacherById(Long id) {
        Teacher teacher = eduTeacherRepository.findAllById(id);
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher currentTeacher) {
        currentTeacher.setEnd(new Date());
        eduTeacherRepository.save(currentTeacher);
    }
}
