package cn.com.dhcc.edu.service;

import cn.com.dhcc.edu.pojo.entity.FirstSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <b>课程分类服务层</b>
 *
 * @author : WMF
 * @since : 2020/7/2 8:28
 */
public interface EduSubjectService {

    /**
     * 添加课程分类
     * @param file
     */
    void saveSubject(MultipartFile file);

    List<FirstSubject> getAllSubject();
}
