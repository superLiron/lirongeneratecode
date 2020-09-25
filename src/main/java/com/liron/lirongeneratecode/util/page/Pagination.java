package com.liron.lirongeneratecode.util.page;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T extends Serializable> implements Serializable {
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -2231176657552169195L;
    private Integer rowsCount = 0;
    private List<T> data;
    private Integer pageCount = 0;
    private Integer pageSize = 0;
    private Integer pageIndex = 0;
    private Integer pageNumber = 0;
    @JsonIgnore
    private RowBounds rowBounds;

    public Pagination() {
    }

    public Pagination(Integer rowsCount, RowBounds rowBounds) {

        this.rowsCount = rowsCount;
        this.rowBounds = rowBounds;
        this.pageSize = rowBounds.getLimit();
        this.pageIndex = rowBounds.getPageIndex();
        this.pageCount = (int) Math.ceil(this.rowsCount * 1.0D / pageSize);

        if (this.pageIndex > this.pageCount) {
            if (this.pageCount == 0) {
                this.pageIndex = 1;
                this.rowBounds = new RowBounds(this.pageIndex, this.pageSize);
            }
        }

        this.pageNumber = this.pageIndex;
    }

    public Pagination(Integer rowsCount, RowBounds rowBounds, List<T> data) {
        this(rowsCount, rowBounds);

        this.setData(data);
    }

    public Pagination(Integer rowsCount, PagingCondition condition) {


        this(rowsCount,  condition.getRowBounds());
    }

    public Pagination(Integer rowsCount, PagingCondition condition, List<T> data) {
        this(rowsCount, condition.getRowBounds(), data);
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        if (null == data) {
            data = new ArrayList<T>();
        }
        this.data = data;
//        if (data.size() > this.rowsCount) {
//            throw new Exception( "The data size is bigger than rowsCount. Please check whether rowsCount is correct or not.");
//        }
    }

    public RowBounds getRowBounds() {
        return rowBounds;
    }

    public Integer getRowsCount() {
        return this.rowsCount;
    }

    public Integer getPageCount() {
        return this.pageCount;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    @Deprecated
    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageIndex = pageNumber;
    }

//    public Integer getPageNumber() {
//        return this.pageNumber;
//    }
}
