public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {

        int min = Integer.MAX_VALUE;
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '1') {
                ++count;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                ++count;
            }
            right[i] = count;
        }

        for (int i = 0; i < len; ++i) {
            min = Math.min(min, left[i] + right[i]);
        }
        return min - 1;
    }
}
