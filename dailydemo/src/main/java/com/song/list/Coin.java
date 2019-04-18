package com.song.list;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class Coin {
    /**
     * 硬币组合
     */
    private static final List<Integer> COIN_COMBINATION = Lists.newArrayList(1, 5, 11);
    private static final List<String> list = Lists.newArrayList();

    public static void main(String[] args) {
      /*  for (int i = 0; i <= 999; i++) {
            String num = "";
            if (i < 10) {
                num = "00" + i;
            } else if (i < 100) {
                num = "0" + i;
            } else {
                num = i + num;
            }
            num = "6451367" + num;
            productOfTwoNo(Long.valueOf(num));
        }
        System.out.println(list);
        System.out.println(list.size());*/


        dpsFind(new Stack<Integer>(), 0, 15);
    }

    /**
     * 回溯递归实现/深度优先遍历
     *
     * @param stack  结果集合
     * @param index  当前遍历的下标
     * @param target 目标结果
     */
    public static void dpsFind(Stack<Integer> stack, int index, int target) {
        if (target == 0) {
            System.out.println(stack);
            return;
        }
        //i != COIN_COMBINATION.size() && target >= COIN_COMBINATION.get(i) 减少调用次数
        for (int i = index; i != COIN_COMBINATION.size() && target >= COIN_COMBINATION.get(i); i++) {
            stack.push(COIN_COMBINATION.get(i));
            dpsFind(stack, i, target - COIN_COMBINATION.get(i));
            stack.pop();
        }
    }

    public static void productOfTwoNo(long product) {
        long max = (long) Math.sqrt(product);
        for (long i = 1; i <= max; i++) {
            if (prime(i)) {
                long j = product / i;
                if (product % i == 0 && prime(product / i)) {
                    //System.out.println(i + "-" + j + "-" + product);
                    list.add(i + "*" + j + "=" + product);
                }
            }
        }
    }

    public static boolean prime(long n) {
        if (n < 2L) {
            return false;
        }
        if (n == 2L || n == 3L) {
            return true;
        }
        long a = (long) Math.sqrt(n);
        for (long i = 2; i <= a; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

