public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {

        int[] arr = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; ++i) {

            int temp = i % 2 == 0 ? arr[i / 2] : arr[i / 2] + arr[(i / 2) + 1];
            arr[i] = temp;
            max = Math.max(max, temp);
        }
        return max;
    }
}
