package LockAdderSubtractor;

import java.util.concurrent.locks.Lock;

public class Subtracter implements Runnable{
    Count count;
    Lock lock;
    Subtracter(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100000; i++) {
            lock.lock();
            count.value-=1;
            lock.unlock();
        }
    }
}
