package cn.com.dhcc.edu.pojo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>一级分类</b>
 *
 * @author : WMF
 * @since : 2020/7/5 20:23
 */
@Data
public class FirstSubject {
    private Long id;
    private String title;
    private List<SecondSubject> childList = new ArrayList<>();
}
