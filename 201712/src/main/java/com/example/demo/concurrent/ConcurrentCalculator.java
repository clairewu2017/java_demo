package com.example.demo.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by chunmei on 1/5/2018.
 */
public class ConcurrentCalculator {

    private ExecutorService threadPool;
    private int cpuCoreNumber;
    private ArrayList<Future<Long>> futureTasks = new ArrayList<>();

    public ConcurrentCalculator() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        threadPool = Executors.newFixedThreadPool(cpuCoreNumber);
    }

    public Long sum(int[] array) throws Exception {

        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = array.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > array.length)
                end = array.length;
            if (start > end) {
                break;
            }
            SumCalculator subCalc = new SumCalculator(array, start, end);
            FutureTask<Long> task = new FutureTask<>(subCalc);
            futureTasks.add(task);
            if (!threadPool.isShutdown()) {
                threadPool.submit(subCalc);
            }
        }

        long sum = 0;
        for (Future<Long> future : futureTasks) {
            Long subSum = future.get();
            sum += subSum;
        }
        return sum;
    }

    public void close() {
        threadPool.shutdown();
    }

}
