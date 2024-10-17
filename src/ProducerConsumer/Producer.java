package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Queue<Object> cars;
    int cap;
    Semaphore ps, cs;

    Producer(Queue<Object> cars, int cap, Semaphore ps, Semaphore cs) {
        this.cars = cars;
        this.cap = cap;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {
        while (true){
            try {
                ps.acquire();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            if(cars.size()<cap){
                System.out.println(cars.size() + "From Producer");
                cars.add(new Object());
            }
            cs.release();
        }

    }
}
