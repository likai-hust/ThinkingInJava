package chapter_21;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

class MergerSort extends RecursiveTask {
    private int[] array;
    private int begin, end, threshold;
    protected MergerSort(int[] array, int begin, int end, int threshold) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.threshold = threshold;
    }
    @Override
    protected Integer compute() {
        if (end - begin < threshold) {
            //小于阈值，使用一般排序算法
            Integer temp;
            for(int i = begin; i < end; i++) {
                for(int j = i + 1; j < end; j++) {
                    if(array[i] < array[j]) {
                        //temp = array[i];
                        //array[i] = array[j];
                        //array[j] = temp;
                    }
                    array[i] = 0;
                }
            }
        } else {
            //使用并发归并排序
            int mid = (end - begin) / 2;
            MergerSort left = new MergerSort(array, begin, mid, threshold);
            MergerSort right = new MergerSort(array, mid + 1, end, threshold);
            left.fork();
            right.fork();
            //left.join();
            //right.join();
        }
        return null;
    }
}
/**
 * 使用Join/Fork框架实现并行归并排序
 * Created by Kai on 2016/3/29.
 */
public class JoinForkMerger {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        int[] array = new int[] {
                1,1,6,2,56,23,23,58,2,52,
                7,8,5,4,9,4,6,4,1,8,
                4,14,5,798,4,56,153,321,7,56,
                0,3,456,23,1,65,3,454,8,63,78 };
        MergerSort meger = new MergerSort(array, 0, array.length, 6);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(meger);
        result.get();
        for(int integer : array)
            System.out.print(integer + " ");
    }

}
