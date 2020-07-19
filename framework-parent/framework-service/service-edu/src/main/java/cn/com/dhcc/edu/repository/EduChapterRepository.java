package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.EduChapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/13 11:01
 */
@Repository
public interface EduChapterRepository extends JpaRepository<EduChapter, Long> {
    @Query(value="SELECT * FROM edu_chapter ec WHERE ec.course_id=?",  nativeQuery = true)
    List<EduChapter> findAllByCourseId(Long courseId);
}
