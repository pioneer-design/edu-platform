package cn.com.dhcc.edu.service.impl;

import cn.com.dhcc.edu.pojo.entity.EduChapter;
import cn.com.dhcc.edu.pojo.entity.EduVideo;
import cn.com.dhcc.edu.pojo.vo.ChapterVo;
import cn.com.dhcc.edu.pojo.vo.VideoVo;
import cn.com.dhcc.edu.repository.EduChapterRepository;
import cn.com.dhcc.edu.repository.EduCourseRepository;
import cn.com.dhcc.edu.repository.EduVideoRepository;
import cn.com.dhcc.edu.service.EduChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/13 11:00
 */
@Service
public class EduChapterServiceImpl implements EduChapterService {

    @Autowired
    EduChapterRepository chapterRepository;
    @Autowired
    EduVideoRepository videoRepository;

    @Override
    public List<ChapterVo> findChapterListByCourseId(Long courseId) {
        // 1. 根据课程ID查询所有的章节
        List<EduChapter> chapterList = chapterRepository.findAllByCourseId(courseId);
        // 2. 根据课程ID查询所有的小节
        List<EduVideo> videoList = videoRepository.findAllByCourseId(courseId);
        List<ChapterVo> finalChapterVoList = new ArrayList<>();
        //3. 封装所有的章节
        for (EduChapter eduChapter : chapterList) {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);
            List<VideoVo> videoVoList = new ArrayList<>();
            for (EduVideo eduvideo : videoList) {
               if (eduvideo.getChapterId().equals(eduChapter.getId())) {
                   VideoVo videoVo = new VideoVo();
                   BeanUtils.copyProperties(eduvideo, videoVo);
                   videoVoList.add(videoVo);
                   chapterVo.setChildList(videoVoList);
               }
            }
            finalChapterVoList.add(chapterVo);
        }
        //4. 封装所有的小节
        return finalChapterVoList;
    }
}
