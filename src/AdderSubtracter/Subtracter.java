package AdderSubtracter;

public class Subtracter implements Runnable{
    Count count;
    Subtracter(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5000; i++) {
            //         lock here
            count.value-=1;
            // unlock
        }
    }
}
