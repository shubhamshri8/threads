package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    Queue<Object> cars;
    int cap;
    Semaphore ps, cs;

    Consumer(Queue<Object> cars, int cap, Semaphore ps, Semaphore cs) {
        this.cars = cars;
        this.cap = cap;
        this.ps = ps;
        this.cs = cs;
    }
    @Override
    public void run() {
        while(true) {
            try {
                cs.acquire();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            if (cars.size() > 0) {
                    System.out.println(cars.size() + "From Consumer");
                    cars.remove();
            }
            ps.release();
            }
    }
}
