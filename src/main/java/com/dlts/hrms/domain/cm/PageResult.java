package com.dlts.hrms.domain.cm;

import java.util.List;

/**
 * Created by admin on 2018/4/16.
 */
public class PageResult<T> {

    private int code=0;
    private long total;
    private List<T> rows;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
