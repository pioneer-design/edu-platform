package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.EduSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <b>课程分类数据持久层</b>
 *
 * @author : WMF
 * @since : 2020/7/2 9:42
 */
public interface EduSubjectRepository extends JpaRepository<EduSubject, Long> {
    @Query(value = "SELECT * FROM edu_subject es WHERE es.parent_id = ?1 AND es.title=?2",nativeQuery = true)
    EduSubject findSubjectByNameAndParentId(Long parentId, String secondSubjectName);

    @Query(value = "SELECT * FROM edu_subject es WHERE es.parent_id = ?", nativeQuery = true)
    List<EduSubject> findAllSubjectByParentId(Long parentId);
}
