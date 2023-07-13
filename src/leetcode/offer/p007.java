package leetcode.offer;

import java.util.*;

public class p007 {
    public static void main(String[] args) {
        Solution987 solution987 = new Solution987();
        solution987.threeSum(new int[]{0, 0, 0});
    }
}

class Solution987 {
    List<List<Integer>> list;
    Set<List<Integer>> set;
    int[] nums;

    public List<List<Integer>> threeSum(int[] nums) {
        //Arrays.sort(nums);
        this.nums = nums;
        //list = new ArrayList<>();
        set = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(path, 0, 0, 0);
        return new ArrayList<>(set);
    }

    public void dfs(List<Integer> path, int idx, int curSum, int len) {
        if (len > 3) return;
        if (len == 3 && curSum == 0) {
            System.out.println(curSum);
            Collections.sort(path);
            set.add(new ArrayList<>(path));
            System.out.println("succes=======>" + path);
            return;

        }
        for (int i = idx; i < nums.length; i++) {
            //if (i > 1 && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            System.out.println("递归前" + path);
            dfs(path, i + 1, curSum + nums[i], len + 1);
            path.remove(path.size() - 1);
            System.out.println("递归后" + path);
        }
    }
}

class Solution23455 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;//跳过第一个会让结果出现重复组合的数
            int left = i + 1, right = length - 1;
            while (left < right) {
                while (left > i + 1 && left < length && nums[left] == nums[left - 1]) left++;//跳过第二个会让结果出现重复组合的数
//                if (left >= right) break;
                if (left < right) {
                    int sum = nums[left] + nums[i] + nums[right];
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[left], nums[i], nums[right]));
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    }
                }

            }
        }
        return list;
    }
}