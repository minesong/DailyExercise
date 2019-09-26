package com.song.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNums {
    public static void main(String[] args) {

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = null;
        ListNode head = null;
        ListNode c = null;
        int flag = 0;
        while (l1 != null && l2 != null) {
            p = c;
            int v = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            c = new ListNode(v);
            if (head == null) {
                head = c;
            }
            if (null != p) {
                p.next = c;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            p = c;
            int v = (l1.val + flag) % 10;
            flag = (l1.val + flag) / 10;
            c = new ListNode(v);
            if (head == null) {
                head = c;
            }
            if (null != p) {
                p.next = c;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            p = c;
            int v = (l2.val + flag) % 10;
            flag = (l2.val + flag) / 10;
            c = new ListNode(v);
            if (head == null) {
                head = c;
            }
            if (null != p) {
                p.next = c;
            }
            l2 = l2.next;
        }
        if (flag == 1) {
            p.next = new ListNode(1);
        }

        return head;
    }

    public static class WordPath {
        public static void main(String[] args) {


        }

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        boolean r = dfs(word, board, i, j, new boolean[board.length][board[0].length], 0);
                        if (r) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(String word, char[][] board, int i, int j, boolean[][] mark, int start) {
            if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
                return false;
            }
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(word.length() - 1) && !mark[i][j];
            }

            boolean r = false;
            if (word.charAt(start) == board[i][j] && !mark[i][j]) {
                mark[i][j] = true;
                r = dfs(word, board, i + 1, j, mark, start + 1) ||

                        dfs(word, board, i - 1, j, mark, start + 1) ||
                        dfs(word, board, i, j + 1, mark, start + 1) ||
                        dfs(word, board, i, j - 1, mark, start + 1);
                if (!r) {
                    mark[i][j] = false;
                } else
                    return true;
            }

            return r;
        }
    }

    public static class ThreeSum {
        public static void main(String[] args) {

            List<Integer> s = Arrays.asList(1,3,5,2);
            System.out.println(s.stream().max(Long::compare));

            //List r = new ThreeSum().threeSum(new int[]{82597, -9243, 62390, 83030, -97960, -26521, -61011, 83390, -38677, 12333, 75987, 46091, 83794, 19355, -71037, -6242, -28801, 324, 1202, -90885, -2989, -95597, -34333, 35528, 5680, 89093, -90606, 50360, -29393, -27012, 53313, 65213, 99818, -82405, -41661, -3333, -51952, 72135, -1523, 26377, 74685, 96992, 92263, 15929, 5467, -99555, -43348, -41689, -60383, -3990, 32165, 65265, -72973, -58372, 12741, -48568, -46596, 72419, -1859, 34153, 62937, 81310, -61823, -96770, -54944, 8845, -91184, 24208, -29078, 31495, 65258, 14198, 85395, 70506, -40908, 56740, -12228, -40072, 32429, 93001, 68445, -73927, 25731, -91859, -24150, 10093, -60271, -81683, -18126, 51055, 48189, -6468, 25057, 81194, -58628, 74042, 66158, -14452, -49851, -43667, 11092, 39189, -17025, -79173, 13606, 83172, 92647, -59741, 19343, -26644, -57607, 82908, -20655, 1637, 80060, 98994, 39331, -31274, -61523, 91225, -72953, 13211, -75116, -98421, -41571, -69074, 99587, 39345, 42151, -2460, 98236, 15690, -52507, -95803, -48935, -46492, -45606, -79254, -99851, 52533, 73486, 39948, -7240, 71815, -585, -96252, 90990, -93815, 93340, -71848, 58733, -14859, -83082, -75794, -82082, -24871, -1});
            //System.out.println(r);
        }

        List<List<Integer>> r = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            dfs(nums, 0, 3, 0, new ArrayList<>());
            return r;
        }

        private void dfs(int[] nums, int index, int target, int sum, ArrayList<Integer> integers) {
            if (target == 0 && sum == 0) {
                r.add(new ArrayList<>(integers));
                return;
            }
            if (index > nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                integers.add(nums[i]);
                dfs(nums, i + 1, target - 1, sum + nums[i], integers);
                integers.remove(integers.size() - 1);
            }
        }
    }
}
