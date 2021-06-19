public class SumOfAllOddLengthSubArrays {

    public int sumOddLengthSubarrays(int[] arr) {

        for (int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i] + arr[i - 1];
        }
        int sum = 0;
        int i = 2;
        while (i < arr.length) {
            int j = i;
            int prev = 0;
            int k = 0;
            while (j < arr.length) {
                sum += arr[j++] - prev;
                prev = arr[k++];
            }
            i += 2;
        }
        return sum + arr[arr.length - 1];
    }
}
