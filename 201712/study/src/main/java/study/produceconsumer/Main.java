package study.produceconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        TestCase1();
    }

    //使用Executor去创建线程池
    private static void TestCase1() {
        study.produceconsumer.StorageWithReentrantLock storage = new StorageWithReentrantLock();

        // 生产者对象
        Producer p1 = new Producer(storage, 10);
        Producer p2 = new Producer(storage, 10);
        Producer p3 = new Producer(storage, 10);
        Producer p4 = new Producer(storage, 10);
        Producer p5 = new Producer(storage, 10);
        Producer p6 = new Producer(storage, 10);
        Producer p7 = new Producer(storage, 80);

        // 消费者对象
        Consumer c1 = new Consumer(storage, 50);
        Consumer c2 = new Consumer(storage, 30);
        Consumer c3 = new Consumer(storage, 30);


        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }


    private static void TestCase2() {
        StorageWithReentrantLock storage = new StorageWithReentrantLock();
        
        ExecutorService producerExecutorService = Executors.newFixedThreadPool(2);
        ExecutorService consumerExecutorService = Executors.newCachedThreadPool();

        consumerExecutorService.execute(new Consumer(storage, 50) );
        consumerExecutorService.execute(new Consumer(storage, 30) );
        consumerExecutorService.execute(new Consumer(storage, 30) );

        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 10));
        producerExecutorService.execute(new Producer(storage, 80));


        producerExecutorService.shutdown();
        producerExecutorService.shutdown();
    }
}
