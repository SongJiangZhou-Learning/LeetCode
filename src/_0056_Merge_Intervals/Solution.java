package _0056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        ArrayList<int[]> result = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            int nextLeft = intervals[i + 1][0];
            int nextRight = intervals[i + 1][1];
            if (right >= nextLeft) {
                if (right < nextRight) {
                    right = nextRight;
                }
            } else {
                result.add(new int[]{left, right});
                left = nextLeft;
                right = nextRight;
            }
        }
        result.add(new int[]{left, right});

        return result.toArray(new int[0][0]);
    }
}