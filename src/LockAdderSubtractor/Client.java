package LockAdderSubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Count count = new Count();
        Adder adder = new Adder(count, lock);
        Subtracter subtracter = new Subtracter(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtracter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
