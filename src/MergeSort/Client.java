package MergeSort;

import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Integer> list = List.of(7,3,1,4,9,8,2,6);
        MergeSorter mergeSorter = new MergeSorter(list, executorService);
//        List<Integer> sortedArray = mergeSorter.call();
        Future<List<Integer>> sortedArray = executorService.submit(mergeSorter);

        System.out.println(sortedArray.get());
    }
}
