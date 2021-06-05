package LeetCodeMay_2021;

public class SumOfAllOddLengthSubArrays {

    public int sumOddLengthSubArrays(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }

        for (int i = 2; i < arr.length; i += 2) {
            sum += windowSum(arr, i);
        }
        return sum;
    }

    private int windowSum(int[] arr, int k) {

        int windowSum = 0;
        for (int i = 0; i <= k; ++i) {
            windowSum += arr[i];
        }

        int sum = windowSum;
        int index = 0;
        for (int i = k + 1; i < arr.length; ++i) {
            sum += arr[i] - arr[index++];
            windowSum += sum;
        }
        return windowSum;
    }
}
