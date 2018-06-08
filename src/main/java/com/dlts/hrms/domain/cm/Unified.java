package com.dlts.hrms.domain.cm;

public class Unified<T> {
    private int result = 0;

    private T data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return this.result == 0;
    }

    public static <A> Unified<A> create(Class<A> c) {
        return new Unified<A>();
    }


}
