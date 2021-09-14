public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }

        int count = 0;
        int i = 0;
        for (int j = k; j < arr.length; ++j) {
            count += sum / k >= threshold ? 1 : 0;
            sum -= arr[i++];
            sum += arr[j];
        }
        count += sum / k >= threshold ? 1 : 0;
        return count;
    }
}
