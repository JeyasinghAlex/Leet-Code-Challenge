public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {

        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                ++count;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = n - 1; i >= 0; --i) {

            char ch = s.charAt(i);
            if (ch == 'a'){
                ++count;
            }
            right[i] = count;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, left[i] + right[i]);
        }
        return min - 1;
    }
}
