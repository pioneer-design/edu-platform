package cn.com.dhcc.edu.service.impl;

import cn.com.dhcc.edu.pojo.entity.ExcelSubjectData;
import cn.com.dhcc.edu.listener.SubjectExcelListener;
import cn.com.dhcc.edu.pojo.entity.FirstSubject;
import cn.com.dhcc.edu.pojo.entity.SecondSubject;
import cn.com.dhcc.edu.pojo.entity.EduSubject;
import cn.com.dhcc.edu.repository.EduSubjectRepository;
import cn.com.dhcc.edu.service.EduSubjectService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>课程分类服务层实现类</b>
 *
 * @author : WMF
 * @since : 2020/7/2 8:29
 */
@Service
public class EduSubjectServiceImpl implements EduSubjectService {

    @Autowired
    private EduSubjectRepository subjectRepository;

    /**
     * 添加课程分类
     * @param file
     */
    @Override
    public void saveSubject(MultipartFile file) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, ExcelSubjectData.class, new SubjectExcelListener(subjectRepository)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取课程分类列表
     * @return
     */
    @Override
    public List<FirstSubject> getAllSubject() {
        //查询一级分类
        Long parentId = 0L;
        List<EduSubject> firstSubjectList = subjectRepository.findAllSubjectByParentId(parentId);
        List<EduSubject> subjectList = subjectRepository.findAll();
        List<FirstSubject> finalSubjectList = new ArrayList<>();

        for (EduSubject eduSubject : firstSubjectList) {
            FirstSubject firstSubject = new FirstSubject();
            BeanUtils.copyProperties(eduSubject, firstSubject);

            List<SecondSubject> secondSubjectList = new ArrayList<>();
            //二级分类parentId不能为 0
            for (EduSubject value : subjectList) {
                if (value.getParentId() != 0
                        && value.getParentId().equals(eduSubject.getId())) {

                    //创建新的二级课程分类，并将查询到的符合条件的课程分类进行转换
                    SecondSubject secondSubject = new SecondSubject();
                    BeanUtils.copyProperties(value, secondSubject);

                    //进行二级课程分类列表封装
                    secondSubjectList.add(secondSubject);

                    //进行一级课程分类封装
                    firstSubject.setChildList(secondSubjectList);
                }
            }
            finalSubjectList.add(firstSubject);
        }
        return finalSubjectList;
    }
}
