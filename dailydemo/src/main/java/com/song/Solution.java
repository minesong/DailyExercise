package com.song;

import com.alibaba.fastjson.JSON;

import javax.json.Json;

public class Solution {
    public static void main(String[] args) {
        new Solution().getMaxWithStack(new int[]{3, 1, 4, 2, 5, 6});
    }

    public void getMaxWithStack(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        MyStack stack = new MyStack();
        MyStack maxStack = new MyStack();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
                maxStack.push(num);
            } else {
                stack.push(num);
                Integer peek = maxStack.getHeadVal();
                if (peek > num) {
                    maxStack.push(peek);
                } else {
                    maxStack.push(num);
                }
            }

        }
        System.out.println(JSON.toJSON(stack));
        System.out.println(JSON.toJSON(maxStack));
        while (!stack.isEmpty()) {
            stack.remove();
            Node max = maxStack.remove();
            System.out.println(JSON.toJSON(max));
        }

    }

}
