package com.dlts.hrms.domain.cm;

import java.util.List;

/**
 * Created by admin on 2018/4/16.
 */
public class PageResult {

    private int code=0;
    private long count;
    private List<?> data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static PageResult create(){
        return new PageResult();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
