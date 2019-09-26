package com.song.leet;

public class TrapWater {
    public int trap(int[] height) {
        if (null == height || height.length <= 2) {
            return 0;
        }
        int maxi = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxi = i;
            }
        }
        int tmpHeight = 0;
        int res = 0;
        for (int i = 0; i < maxi; i++) {
            if (height[i] < tmpHeight) {
                res += (tmpHeight - height[i]);
            }
            tmpHeight = Math.max(height[i], tmpHeight);
        }
        tmpHeight = 0;
        for (int i = height.length - 1; i > maxi; i--) {
            if (height[i] < tmpHeight) {
                res += (tmpHeight - height[i]);
            }
            tmpHeight = Math.max(height[i], tmpHeight);
        }
        return res;
    }
}
