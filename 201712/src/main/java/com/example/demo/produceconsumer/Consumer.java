package com.example.demo.produceconsumer;

/**
 * Created by chunmei on 12/28/2017.
 */
public class Consumer  extends Thread{
    private StorageWithReentrantLock storage;
    int num;
    public Consumer(StorageWithReentrantLock storage, int num)
    {
        this.storage = storage;
        this.num = num;
    }


    @Override
    public void run() {
        try {
            storage.Consume(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
