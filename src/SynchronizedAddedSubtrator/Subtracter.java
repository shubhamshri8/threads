package SynchronizedAddedSubtrator;

public class Subtracter implements Runnable{
    Count count;
    Subtracter(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100000; i++) {
            count.incrementValue(-i);
        }
    }
}
