package com.liron.lirongeneratecode.util.page;


import java.io.Serializable;

public class PagingCondition implements Serializable {
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -7856152493002957390L;
    private Integer pageIndex = 1;
    private Integer pageSize = 10;
    private Integer pageNumber = 1;

    @Deprecated
    public Integer getPageIndex() {
        return pageIndex;
    }

    @Deprecated
    public void setPageIndex(Integer pageIndex) {
        this.pageNumber = pageIndex;
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.pageIndex = pageNumber;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public RowBounds getRowBounds() {
        return new RowBounds(getPageNumber(), getPageSize());
    }
}

