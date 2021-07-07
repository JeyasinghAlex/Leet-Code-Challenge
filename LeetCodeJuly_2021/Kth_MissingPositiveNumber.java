import java.util.ArrayList;
import java.util.List;

public class Kth_MissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {

        for (int i = 1, j = 0; k >= 0; ++i) {

            if (j < arr.length && arr[j] == i) {
                ++j;
            } else {
                --k;
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    public int findKthPositive_1(int[] arr, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 2000; ++i) {
            list.add(i);
        }

        for (int n : arr) {
            int idx = list.indexOf(n);
            list.remove(idx);
        }

        return list.get(k - 1);
    }
}
