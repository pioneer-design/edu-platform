package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.EduCourseDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/10 15:39
 */
@Repository
public interface EduCourseDescRepository extends JpaRepository<EduCourseDesc, Long> {
    EduCourseDesc findAllById(Long courseId);
}
