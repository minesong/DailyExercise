package com.song.leet;

import java.util.Stack;

public class canCompleteCircuit {
    public static void main(String[] args) {
        int r = new canCompleteCircuit().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]
                {3, 4, 5, 1, 2});
        System.out.println(r);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int toil = gas[i] - cost[i];
            if (toil < 0) {
                continue;
            }
            int j = (i + 1) % gas.length;
            boolean is = false;
            while (j < i + gas.length) {
                int id = (j) % gas.length;
                toil += (gas[id] - cost[id]);
                if (toil < 0) {
                    is = true;
                    break;
                }
                j++;
            }
            if (!is) {
                return i;
            }
        }
        return -1;

    }

    int canCompleteCircuit2(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }
}
