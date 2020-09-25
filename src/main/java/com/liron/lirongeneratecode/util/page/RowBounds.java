package com.liron.lirongeneratecode.util.page;

import java.io.Serializable;

public class RowBounds extends org.apache.ibatis.session.RowBounds implements Serializable {
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -3212443343810584546L;
    private int pageIndex;
    private int pageSize;

    private RowBounds() {

    }

    public RowBounds(int pageIndex, int pageSize) {
        super(((pageIndex - 1) * pageSize), pageSize);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}
