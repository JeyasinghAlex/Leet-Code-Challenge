package LeetCodeMay_2021;

public class ShortestSubArrayToBeRemovedToMakeArraySorted {

    public int findLengthOfShortestSubArray(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j && arr[i] <= arr[i + 1]) {
            ++i;
        }

        if (i == j) {
            return 0;
        }

        while (j > 0 && arr[j] >= arr[j - 1]) {
            --j;
        }

        int minLength = Math.min(arr.length - 1 - i, j);
        int k = i;
        i = 0;

        while (i <= k && j < arr.length) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                ++i;
            } else {
                ++j;
            }
        }
        return minLength;
    }
}
