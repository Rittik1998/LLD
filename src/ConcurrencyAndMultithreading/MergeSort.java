package ConcurrencyAndMultithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(7,5,8,2,2,5,1);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Integer> sortedArray = executor.submit(new Sorter(arrayToSort,executor)).get();
        System.out.println(sortedArray);
        executor.shutdown();
    }
}

class Sorter implements Callable<List<Integer>>{
    private List<Integer> arrayToSort;
    private ExecutorService executor;

    public Sorter(List<Integer> arrayToSort, ExecutorService executor) {
        this.arrayToSort = arrayToSort;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        int length = arrayToSort.size();
        if(length<=1) return arrayToSort;
        int mid = length/2;

        List<Integer> leftArray = new ArrayList<>();

        for(int i=0; i<mid; i++){
            leftArray.add(arrayToSort.get(i));
        }


        List<Integer> rightArray = new ArrayList<>();

        for(int i=mid; i<length; i++){
            rightArray.add(arrayToSort.get(i));
        }

        Future<List<Integer>> leftSortedArrayFuture = executor.submit(new Sorter(leftArray,executor));
        Future<List<Integer>> rightSortedArrayFuture = executor.submit(new Sorter(rightArray,executor));

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        int i=0, j=0;
        int m = leftSortedArray.size(), n = rightSortedArray.size();
        List<Integer> sortedArray = new ArrayList<>();

        while(i<m && j<n){
            if(leftSortedArray.get(i)<rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }
            else{
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i<m){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j<n){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }
        return  sortedArray;
    }
}
