package cn.com.dhcc.edu.pojo.vo;

import cn.com.dhcc.edu.pojo.entity.SecondSubject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/13 11:05
 */
@Data
public class ChapterVo {
    private Long id;
    private String title;
    private List<VideoVo> childList = new ArrayList<>();
}
