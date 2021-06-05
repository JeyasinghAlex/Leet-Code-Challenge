package LeetCodeJun_2021;

import java.util.Arrays;

public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int hi, int wi, int[] h, int[] v) {

        Arrays.sort(h);
        Arrays.sort(v);

        int maxH = Math.max(h[0], hi - h[h.length - 1]);
        int maxV = Math.max(v[0], wi - v[v.length - 1]);

        for (int i = 1; i < h.length; ++i) {
            maxH = Math.max(maxH, h[i] - h[i - 1]);
        }

        for (int i = 1; i < v.length; ++i) {
            maxV = Math.max(maxV, v[i] - v[i - 1]);
        }

        long ans = (long) maxH * maxV;

        return (int) (ans % 1000000007);
    }
}