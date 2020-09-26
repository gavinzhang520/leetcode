package com.gavin.leetcode.april;

/**
 * #42.接水滴
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @Author Gavin
 * @Date 2020/4/4
 * @Time 19:52
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int res = 0;
        //遍历每根柱子
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            //计算当前柱子左侧的柱子中的最大高度
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //计算当前柱子右侧的柱子中的最大高度
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

}
