package study.concurrent;

import java.util.concurrent.*;

/**
 * Created by chunmei on 1/5/2018.
 */
public class ConcurrentCalculator2 {

    private ExecutorService exec;
    private CompletionService<Long> completionService;


    private int cpuCoreNumber;

    public ConcurrentCalculator2() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        exec = Executors.newFixedThreadPool(cpuCoreNumber);
        ((ThreadPoolExecutor)exec).setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        ((ThreadPoolExecutor)exec).setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        ((ThreadPoolExecutor)exec).setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        ((ThreadPoolExecutor)exec).setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        completionService = new ExecutorCompletionService<Long>(exec);


    }

    public Long sum(final int[] numbers) {
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length)
                end = numbers.length;
            SumCalculator subCalc = new SumCalculator(numbers, start, end);
            if (!exec.isShutdown()) {
                completionService.submit(subCalc);


            }

        }
        return getResult();
    }

    /**
     * 迭代每个只任务，获得部分和，相加返回
     *
     * @return
     */
    public Long getResult() {
        Long result = 0l;
        for (int i = 0; i < cpuCoreNumber; i++) {
            try {
                Long subSum = completionService.take().get();
                result += subSum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void close() {
        exec.shutdown();
    }
}
