package com.example.demo.concurrent;

import java.util.concurrent.Callable;

/**
 * Created by chunmei on 1/5/2018.
 */
public class SumCalculator implements Callable<Long> {
    private int [] array;
    private int start;
    private int end;

    public SumCalculator(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for(int i = start; i < end; i ++)
        {
            sum += array[i];
        }
        return sum;
    }
}
