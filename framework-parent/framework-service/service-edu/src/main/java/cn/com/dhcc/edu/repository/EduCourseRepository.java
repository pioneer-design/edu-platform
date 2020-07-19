package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.EduCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <b>课程数据持久层</b>
 *
 * @author : WMF
 * @since : 2020/7/9 9:09
 */
public interface EduCourseRepository extends JpaRepository<EduCourse, Long> {

    EduCourse findAllById(Long courseId);
}
