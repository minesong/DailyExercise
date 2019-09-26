package com.song.leet;


import java.util.HashMap;
import java.util.Map;

public class MaxProfit3 {
    public static void main(String[] args) {
        boolean r = new MaxProfit3().lemonadeChange(new int[]{5,5,5,10,20});
        System.out.println(r);

    }

    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }
        int ten = 0;
        int five = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
                continue;
            }
            if (bills[i] == 10) {
                ten++;
                five--;

            }
            if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five = five - 3;
                }
            }
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int K = 2;
        int[][] dp = new int[prices.length][K + 1];
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i < prices.length; i++) {
                //比较不操作和选择一天买入的哪个值更大
                for (int buy = 0; buy <= i; buy++) {
                    int t;
                    if (buy == 0) {
                        t = Math.max(dp[i - 1][k], prices[i] - prices[buy]);
                    } else {
                        t = Math.max(dp[i - 1][k], prices[i] - prices[buy] + dp[buy - 1][k - 1]);

                    }
                    dp[i][k] = Math.max(dp[i][k], t);
                }
                System.out.println(dp[i][k]);
            }
            System.out.println();
        }
        return dp[prices.length - 1][K];
    }

}
