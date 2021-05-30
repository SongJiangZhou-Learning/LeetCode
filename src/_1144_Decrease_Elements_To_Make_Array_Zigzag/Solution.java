package _1144_Decrease_Elements_To_Make_Array_Zigzag;

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        // 小大小
        int smallBigSmall = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            smallBigSmall = getSmallBigSmall(nums, smallBigSmall, i);
        }

        // 大小大
        int bigSmallBig = 0;
        for (int i = 1; i < nums.length; i = i + 2) {
            bigSmallBig = getSmallBigSmall(nums, bigSmallBig, i);
        }

        return Math.min(smallBigSmall, bigSmallBig);
    }

    private int getSmallBigSmall(int[] nums, int smallBigSmall, int i) {
        int cur = nums[i];
        int left = i - 1 < 0 ? cur + 1  : nums[i - 1];
        int right = i + 1 == nums.length ? cur + 1 : nums[i + 1];
        int small = Math.min(left, right);
        if (cur >= small) {
            smallBigSmall += nums[i] - (small - 1);
        }
        return smallBigSmall;
    }
}
