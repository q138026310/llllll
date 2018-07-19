package com.dlts.hrms.domain.cm;

import java.util.List;

/**
 * Created by admin on 2018/4/16.
 */
public class PageResult<T> {

    private int code=0;
    private long count;
    private List<T> data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static <T> PageResult<T> create(){
        return new PageResult<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
