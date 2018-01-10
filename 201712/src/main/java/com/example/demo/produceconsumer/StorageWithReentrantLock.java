package com.example.demo.produceconsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chunmei on 12/28/2017.
 */
public class StorageWithReentrantLock {
    private LinkedList<Object> list = new LinkedList<Object>();

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void Produce(int num) throws InterruptedException {
        lock.lock();

        while(list.size() + num > 100)
        {
            System.out.println("Full");
            condition.await();
        }

        for(int i = 0; i < num; i++)
        {
            list.add(new Object());
        }
        condition.signalAll();
        System.out.println("Now " + list.size());
        lock.unlock();
    }

    public void Consume(int num) throws InterruptedException {
        lock.lock();
        while(list.size() < num)
        {
            System.out.println("Empty");
            condition.await();
        }

        for (int i = 0 ; i < num; i ++)
        {
            list.pop();
        }

        condition.signalAll();
        lock.unlock();

        System.out.println("Now " + list.size());
    }
}
