package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/6/23 16:57
 */
@Repository
public interface EduTeacherRepository extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {

    Teacher findAllById(Long id);
}
