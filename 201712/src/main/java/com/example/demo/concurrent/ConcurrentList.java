package com.example.demo.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by chunmei on 1/5/2018.
 */
public class ConcurrentList {

    public void Test(){
        List list = Arrays.asList(1, 2, 3, 4);
        //两种实现多线程安全列表的方式
        List sycnhronizedList = Collections.synchronizedList(list);
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
    }
}

