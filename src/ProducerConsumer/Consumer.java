package ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable{

    Queue<Object> cars;
    int cap;

    Consumer(Queue<Object> cars, int cap) {
        this.cars = cars;
        this.cap = cap;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (cars) {
                if (cars.size() > 0) {
                    System.out.println(cars.size() + "From Consumer");
                    cars.remove();
                }
            }
        }
    }
}
