package com.dlts.hrms.utils;

import java.util.ArrayList;

/**
 * Created by admin on 2018/4/10.
 */
public class ListUtils {

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> newArrayList(int initialCapacity) {
        return new ArrayList(initialCapacity);
    }

}
