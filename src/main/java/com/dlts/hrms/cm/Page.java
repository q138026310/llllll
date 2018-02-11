package com.dlts.hrms.cm;

import java.util.List;

public class Page {

    private int count;
    private List<?> list;

    public static Page newPage(int count, List<?> list) {
        Page p = new Page();
        p.count = count;
        p.list = list;
        return p;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }



}
