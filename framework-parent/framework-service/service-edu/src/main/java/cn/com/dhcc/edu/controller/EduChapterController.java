package cn.com.dhcc.edu.controller;

import cn.com.dhcc.common.core.R;
import cn.com.dhcc.edu.pojo.vo.ChapterVo;
import cn.com.dhcc.edu.service.EduChapterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>章节控制器</b>
 *
 * @author : WMF
 * @since : 2020/7/13 10:59
 */
@Api(tags = "章节控制器")
@RestController
@RequestMapping("edu/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    EduChapterService eduChapterService;

    @GetMapping("getChapter/{courseId}")
    public R getChapterListByCourseId(@PathVariable Long courseId) {
        List<ChapterVo> chapterVoList = eduChapterService.findChapterListByCourseId(courseId);
        if (chapterVoList != null) {
            return R.ok().data("list", chapterVoList);
        }
        return R.error().message("查询失败");
    }

}
