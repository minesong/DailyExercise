package com.song.leet;


import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {
        int[] nums = {16, 7, 6, 3, 20, 17, 6};
        headSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 堆排序、最大堆
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }

    /**
     * 往下调整堆
     *
     * @param list
     * @param len  剩余长度
     * @param i    从下标i开始调整
     */
    private static void headAdjust(int[] list, int len, int i) {
        int k = i, index = 2 * k + 1;
        while (index < len) {
            //找出左右子树较大者
            if (index + 1 < len && list[index] < list[index + 1]) {
                index = index + 1;
            }
            if (list[index] > list[k]) {
                int temp = list[k];
                list[k] = list[index];
                list[index] = temp;
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
    }
}
