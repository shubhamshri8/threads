package Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NumberPrinter implements Runnable {
    int num;

    NumberPrinter(int value) {
        num = value;
    }
    @Override
    public void run() {
    System.out.println("Printing " + this.num + "Printed By " + Thread.currentThread().getName());
    }
}

public class PrintNumbers {
    public static void main(String[] args) {
//        System.out.println("Hello! Shubham " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for(int i =1; i<=500; i++){
            NumberPrinter printer = new NumberPrinter(i);
            executorService.submit(printer);
        }

        executorService.shutdown();


    }
}

