public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            if (arr[i + 1] > arr[i])  {
                ++i;
            } else if (arr[j] > arr[j - 1]) {
                --j;
            } else {
                return i;
            }
        }
        return -1;
    }
}
