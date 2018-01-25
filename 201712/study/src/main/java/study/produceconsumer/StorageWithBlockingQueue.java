package study.produceconsumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chunmei on 12/28/2017.
 */
class StorageWithBlockingQueue {
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(100);

    public void Produce(int num) throws InterruptedException {
        if(list.size() == 100)
        {
            System.out.println("Full");
        }

        for(int i = 0; i < num; i++)
        {
            list.put(new Object());
        }
        System.out.println("Now " + list.size());
    }

    public void Consume(int num) throws InterruptedException {
        if(list.size() == 0)
        {
            System.out.println("Empty");
        }

        for (int i = 0 ; i < num; i ++)
        {
            list.take();
        }

        System.out.println("Now " + list.size());
    }
}
