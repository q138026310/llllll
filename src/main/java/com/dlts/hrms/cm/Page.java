package com.dlts.hrms.cm;

import java.util.List;

public class Page<A> {

    private int count;
    private List<A> list;

    public static <T> Page<T> newPage(int count, List<T> list) {
        Page<T> p = new Page<T>();
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

    public List<A> getList() {
        return list;
    }

    public void setList(List<A> list) {
        this.list = list;
    }



}
