public class LongestMountainInArray {

    public int longestMountain(int[] arr) {

        int n = arr.length;
        if (n < 3) {
            return 0;
        }

        int max = 0;
        int i = 1;
        while (i < n) {

            int incr = 0;
            int decr = 0;
            while (i < n && arr[i] > arr[i - 1]) {
                ++incr;
                ++i;
            }

            while (i < n && arr[i - 1] > arr[i]) {
                ++decr;
                ++i;
            }

            while(i < n && arr[i - 1] == arr[i]) {
                ++i;
            }

            if (incr > 0 && decr > 0) {
                max = Math.max(max, incr + decr + 1);
            }
        }
        return max;
    }
}
