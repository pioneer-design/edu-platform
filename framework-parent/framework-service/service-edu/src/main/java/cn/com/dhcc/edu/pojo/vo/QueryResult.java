package cn.com.dhcc.edu.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/6/23 18:01
 */
@Data
public class QueryResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> list;

    private long total;
}
