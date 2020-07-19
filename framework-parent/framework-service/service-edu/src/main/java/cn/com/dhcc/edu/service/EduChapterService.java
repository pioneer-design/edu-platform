package cn.com.dhcc.edu.service;

import cn.com.dhcc.edu.pojo.vo.ChapterVo;

import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/13 11:00
 */
public interface EduChapterService {
    List<ChapterVo> findChapterListByCourseId(Long courseId);
}
