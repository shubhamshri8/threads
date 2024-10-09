package MergeSort;

import com.sun.jdi.request.MethodEntryRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrayToBeSorted;
    private ExecutorService executorService;

    MergeSorter(List<Integer> arrayToBeSorted, ExecutorService executorService) {
        this.arrayToBeSorted = arrayToBeSorted;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception{
        //Base Case
        if(arrayToBeSorted.size() <= 1) return arrayToBeSorted;
        int mid = arrayToBeSorted.size()/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i =0; i< mid; i++) left.add(arrayToBeSorted.get(i));
        for(int i = mid; i <arrayToBeSorted.size(); i++) right.add(arrayToBeSorted.get(i));

        MergeSorter leftMergeSorter = new MergeSorter(left, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(right, executorService);

//        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<List<Integer>> futureSortedLeft = executorService.submit(leftMergeSorter);
        Future<List<Integer>> futureSortedRight = executorService.submit(rightMergeSorter);

        System.out.println(Thread.currentThread().getName());

        List<Integer> sortedLeft = futureSortedLeft.get();
        List<Integer> sortedRight = futureSortedRight.get();

        int i=0, j=0;

        List<Integer> sortedArray = new ArrayList<>();
        while (i <sortedLeft.size() && j < sortedRight.size()) {
            if(sortedLeft.get(i) < sortedRight.get(j)) {
                sortedArray.add(sortedLeft.get(i));
                i+=1;
            }
            else {
                sortedArray.add(sortedRight.get(j));
                j+=1;
            }
        }
        while(i < sortedLeft.size()){
            sortedArray.add(sortedLeft.get(i));
            i+=1;
        }
        while(j < sortedRight.size()){
            sortedArray.add(sortedRight.get(j));
            j+=1;
        }

        System.out.println(sortedArray);
        return sortedArray;
    }
}
