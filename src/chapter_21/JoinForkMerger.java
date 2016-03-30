package chapter_21;

import java.util.Arrays;
import java.util.concurrent.*;

class MergerSort extends RecursiveTask<int[]> {
    private int[] array;
    private int begin, end, threshold;
    protected MergerSort(int[] array, int begin, int end, int threshold) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.threshold = threshold;
    }
    private void merger(int begin, int mid, int end) {
        int i = begin, j = mid + 1, k = 0;
        int[] temp = new int[end - begin + 1];
        while (i <= mid && j <= end) {
            if(array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while(i <= mid)
            temp[k++] = array[i++];
        while(j <= end)
            temp[k++] = array[j++];
        while(--k >= 0)
            array[end--] = temp[k];
    }
    @Override
    protected int[] compute() {
        if (end - begin < threshold) {
            //小于阈值，使用一般排序算法
            Arrays.sort(array, begin, end + 1);
        } else {
            //使用并发归并排序
            int mid = (end + begin) / 2;
            MergerSort left = new MergerSort(array, begin, mid, threshold);
            MergerSort right = new MergerSort(array, mid + 1, end, threshold);
            left.fork().join();
            right.fork().join();
            merger(begin, mid, end);
        }
        return array;
    }
}
/**
 * 使用Join/Fork框架实现并发归并排序
 * Created by Kai on 2016/3/29.
 */
public class JoinForkMerger {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        int[] array = new int[]{
                1, 1, 6, 2, 56, 23, 23, 58, 2, 52,
                7, 8, 5, 4, 9, 4, 6, 4, 1, 8,
                4, 14, 5, 798, 4, 56, 153, 321, 7, 56,
                0, 3, 456, 23, 1, 65, 3, 454, 8, 63, 78};
        MergerSort merger = new MergerSort(array, 0, array.length - 1, 8);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(merger);
        while(!result.isDone());
        if (result.isDone()) {
            for (int integer : array)
                System.out.print(integer + " ");

        }
    }
}
