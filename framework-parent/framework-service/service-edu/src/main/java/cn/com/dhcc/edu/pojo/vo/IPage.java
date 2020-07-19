package cn.com.dhcc.edu.pojo.vo;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * <b>分页视图对象</b>
 *
 * @author : WMF
 * @since : 2020/6/23 17:09
 */
@Data
public class IPage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageIndex;    //当前页码

    private Integer pageSize;     //每页显示的记录数

    private long total;           //记录总数

    private Integer pageCount;    //总页数

    private List<T> list;         //返回的结果集

    public IPage() { }
    public IPage(Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
        if (pageSize == null || pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize < 1 ? 10 : pageSize;
    }

    public void setTotal(long total) {
        this.total = total;
        if (total % this.pageSize == 0) {
            this.pageCount =(int)(total % this.pageSize);
        } else {
            this.pageCount =(int)(total % this.pageSize + 1);
        }
    }
}
