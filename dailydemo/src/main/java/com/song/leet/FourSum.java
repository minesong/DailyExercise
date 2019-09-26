package com.song.leet;

import javax.persistence.Id;
import java.util.*;

public class FourSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ret;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1])
                        begin++;
                    while (begin < end && nums[end] == nums[end + 1])
                        end--;

                } else if (sum > 0)
                    end--;
                else
                    begin++;

            }
        }
        return ret;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return ret;
        int len = nums.length;
        Arrays.sort(nums);
        // 注意，对于 num[i]，寻找另外两个数时，只要从 i+1 开始找就可以了。
        // 这种写法，可以避免结果集中有重复，因为数组时排好序的，所以当一个数被放到结果集中的时候，其后面和它相等的直接被跳过。
        for (int i = 0; i < len; i++) {
            // 可省，目的减少无意义的循环
            // 避免重复！！！！
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                // 往后找，避免重复
                int begin = j + 1;
                int end = len - 1;
                while (begin < end) {
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        begin++;
                        end--;
                        // 避免重复！！！！
                        while (begin < end && nums[begin] == nums[begin - 1])
                            begin++;
                        while (begin < end && nums[end] == nums[end + 1])
                            end--;
                    } else if (sum > target)
                        end--;
                    else
                        begin++;
                }
            }
        }
        return ret;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        int target = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                target = 0 - c - d;
                cnt += map.getOrDefault(target, 0);
            }
        }
        return cnt;

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0, res);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        //new FourSum().permute(new int[]{1, 1, 3, 2});
        //new FourSum().permute2(new int[]{1, 1, 3, 2});
        new FourSum().com(new int[]{1, 2, 3},0);
    }

    private void permute(int[] nums, int level, List<List<Integer>> res) {
        if (level == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                tmp.add(nums[i]);
            }
            res.add(tmp);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            swap(nums, i, level);
            permute(nums, level + 1, res);
            swap(nums, i, level);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, nums.length, vis);
        System.out.println(ret);
        return ret;
    }

    // DFS+回溯
    private void dfs(int[] nums, int idx, int len, boolean[] vis) {
        if (tmp.size() == len) {
            ret.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
                continue;
            if (vis[i])
                continue;
            // 遇到已经加过的元素就跳过
            vis[i] = true;
            // 加入该元素后继续搜索
            tmp.add(nums[i]);
            // 可以不传i+1参数，但是递归次数增多
            dfs(nums, i + 1, len, vis);
            tmp.remove(tmp.size() - 1);
            vis[i] = false;
        }
    }

    List<Integer> com = new ArrayList<>();

    public void com(int[] nums, int cur) {
        if (cur <= nums.length) {
            System.out.println(com);
        }

        for (int i = cur; i < nums.length; i++) {
            com.add(nums[i]);
            com(nums, i + 1);
            com.remove(com.size() - 1);
        }
    }
}
