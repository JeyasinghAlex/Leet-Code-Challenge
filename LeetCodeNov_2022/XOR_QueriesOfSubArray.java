public class XOR_QueriesOfSubArray {

    public int[] xorQueries(int[] arr, int[][] queries) {

        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        // a ^ b = total;
        // b = total ^ a;
        for (int i = 0; i < n; ++i) {
            int[] querie = queries[i];
            int a = querie[0];
            int total = querie[1];
            ans[i] = a == 0 ?  arr[total] : arr[a - 1] ^ arr[total];
        }
        return ans;
    }

    public int[] xorQueries_1(int[] arr, int[][] queries) {

        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int xor = 0;
            for (int j = left; j <= right; ++j) {
                xor ^= arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }
}
