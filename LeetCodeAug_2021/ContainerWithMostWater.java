public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (start < end) {

            if (height[start] < height[end]) {
                max = Math.max(max, height[start] * (end - start));
                ++start;
            } else {
                max = Math.max(max, height[end] * (end - start));
                --end;
            }
        }
        return max;
    }
}
