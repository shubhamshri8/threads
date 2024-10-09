//
//
//class NumberPrinter implements Runnable{
//
//    int number;
//
//    NumberPrinter(int number) {
//        this.number = number;
//    }
//    @Override
//    public void run() {
//        System.out.printf("%d, printed by thread: %s\n", number, Thread.currentThread().getName());
//    }
//}
//
//// Print al no from 1-100 by separate threads;
//
//public class Main {
//    public static void main(String[] args) {
//    System.out.println("Hello! Shubham " + Thread.currentThread().getName());
//
//
//    for(int i =1; i<=500; i++){
//        NumberPrinter printer = new NumberPrinter(i);
//        Thread t = new Thread(printer);
//        t.start();
//    }
//
//
//    }
//}