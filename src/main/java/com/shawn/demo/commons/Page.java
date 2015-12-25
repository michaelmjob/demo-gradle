package com.shawn.demo.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Shawn on 2015/12/23.
 */
public class Page<T> implements Serializable {
    private Long pageIndex;
    private Integer pageSize = Constants.DEFAULT_PAGESIZE;
    List<T> rows;
    private Long total;
    private Long pageTotal;
    private Boolean hasPrevPage;
    private Boolean hasNextPage;

    public Page(Long pageIndex, Integer pageSize) {
        this.pageIndex = null == pageIndex ? 1 : pageIndex;
        this.pageSize = null == pageSize ? Constants.DEFAULT_PAGESIZE : pageSize;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
        this.pageTotal = this.total % this.pageSize == 0 ? this.total / this.pageSize : this.total / this.pageSize + 1;
        this.hasPrevPage = this.pageIndex > 1 ? Boolean.TRUE : Boolean.FALSE;
        this.hasNextPage = this.pageIndex < this.pageTotal ? Boolean.TRUE : Boolean.FALSE;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

//    public void setPageTotal(Long pageTotal) {
//        this.pageTotal = pageTotal;
//    }

    public Boolean getHasPrevPage() {
        return hasPrevPage;
    }

//    public void setHasPrevPage(Boolean hasPrevPage) {
//        this.hasPrevPage = hasPrevPage;
//    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

//    public void setHasNextPage(Boolean hasNextPage) {
//        this.hasNextPage = hasNextPage;
//    }
}
