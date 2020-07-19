package cn.com.dhcc.edu.listener;

import cn.com.dhcc.edu.pojo.entity.ExcelSubjectData;
import cn.com.dhcc.edu.pojo.entity.EduSubject;
import cn.com.dhcc.edu.repository.EduSubjectRepository;
import cn.com.dhcc.exception.GuliException;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Date;

/**
 * <b> Excel 监听器</b>
 *
 * @author : WMF
 * @since : 2020/7/2 8:43
 */
public class SubjectExcelListener extends AnalysisEventListener<ExcelSubjectData> {

    //SubjectExcelListener不能交给spring 进行管理，需要自己new ,不能注入其他对象
    //不能实现数据库操作

    public EduSubjectRepository subjectRepository;

    public SubjectExcelListener() {}
    public SubjectExcelListener(EduSubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void invoke(ExcelSubjectData subjectData, AnalysisContext analysisContext) {
        //判断文件中的数据不能为空
        if (subjectData == null) {
            throw new GuliException(20001, "数据不能为空");
        }
        //判断一级分类是否重复
        EduSubject firstSubject = this.isExistFirstSubject(subjectRepository, subjectData.getFirstSubjectName());
        if (firstSubject == null) {
             firstSubject = new EduSubject(0L, subjectData.getFirstSubjectName(), new Date(), new Date());
             //保存一级分类
             subjectRepository.save(firstSubject);
        }
        Long parentId = firstSubject.getId();
        //判断二级分类是否重复
        EduSubject secondSubject = this.isExistSecondSubject(subjectRepository, subjectData.getSecondSubjectName(), parentId);
        if (secondSubject == null) {
            secondSubject = new EduSubject(parentId, subjectData.getSecondSubjectName(), new Date(), new Date());
            //保存二级分类
            subjectRepository.save(secondSubject);
        }
        
    }

    private EduSubject isExistSecondSubject(EduSubjectRepository subjectRepository, String secondSubjectName, Long parentId) {
        EduSubject secondSubject = subjectRepository.findSubjectByNameAndParentId(parentId, secondSubjectName);
        return secondSubject;
    }

    private EduSubject isExistFirstSubject(EduSubjectRepository subjectRepository, String firstSubjectName) {
        Long parentId = 0L;
        EduSubject firstSubject = subjectRepository.findSubjectByNameAndParentId(parentId, firstSubjectName);
        return firstSubject;
    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
