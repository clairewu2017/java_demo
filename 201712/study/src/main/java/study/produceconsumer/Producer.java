package study.produceconsumer;

/**
 * Created by chunmei on 12/28/2017.
 */
public class Producer extends Thread{
    private StorageWithReentrantLock storage;
    int num;
    public Producer(StorageWithReentrantLock storage, int num)
    {
        this.storage = storage;
        this.num = num;
    }


    @Override
    public void run() {
        try {
            storage.Produce(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
