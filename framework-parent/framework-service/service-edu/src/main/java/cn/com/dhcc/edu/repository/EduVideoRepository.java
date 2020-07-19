package cn.com.dhcc.edu.repository;

import cn.com.dhcc.edu.pojo.entity.EduVideo;
import cn.com.dhcc.edu.pojo.vo.VideoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/13 11:16
 */
@Repository
public interface EduVideoRepository extends JpaRepository<EduVideo, Long> {
    @Query(value="SELECT * FROM edu_video ev WHERE ev.course_id=?",  nativeQuery = true)
    List<EduVideo> findAllByCourseId(Long courseId);
}
