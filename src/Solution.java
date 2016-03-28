import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] count = new int[candidates.length];
        List<List<Integer>> result = new ArrayList<>();
        solve(count, candidates.length - 1, candidates, target, result);
        List<List<Integer>> r = new ArrayList<>();
        for(int i = result.size() - 1; i >= 0; i--) {
            r.add(result.get(i));
        }
        return r;
    }
    private boolean solve(int[] count, int n, int[] candidates, int target, List<List<Integer>> result) {
        if(n < 0)
            return false;
        else {
            for(int j = 0; j < 2; j++) {
                count[n] = j;
                int checkSign = check(count, n, candidates, target);
                if(checkSign != 1) {
                    if(checkSign == 0 && count[n] != 0)    //找到结果，存储
                        result.add(saveResult(count, n, candidates));
                    if(solve(count, n - 1, candidates, target, result))
                        return true;
                } else
                    break;
            }
            return false;
        }
    }
    private int check(int[] count, int n, int[] candidates, int target) {
        int sum = 0;
        for(int i = n; i < candidates.length; i++) {
            sum += count[i] * candidates[i];
            if(sum > target)
                return 1;
        }
        if(sum == target)
            return 0;
        return -1;
    }
    private List<Integer> saveResult(int[] count, int n, int[] candidates) {
        List<Integer> result = new ArrayList<>();
        for(int i = n; i < candidates.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add(candidates[i]);
            }
        }
        return result;
    }
    public static void main(String... args) {
        for(List<Integer> list : new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)) {
            for(Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}