import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println(new FindKClosestElements().findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public List<Integer> findClosestElements_1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int idx = lowerBond(arr, x);
        if (idx == 0) {
            for (int i = 0; i < k; ++i) {
                list.add(arr[i]);
            }
            return list;
        }

        int prev = idx - 1;
        int next = idx;
        int count = 0;
        while (prev >= 0 && next < arr.length && count < k) {
            int a = Math.abs(x - arr[next]);
            int b = Math.abs(x - arr[prev]);
            if (a < b) {
                list.add(arr[next++]);
            } else {
                list.add(arr[prev--]);
            }
            ++count;
        }

        while (prev >= 0 && count < k) {
            list.add(arr[prev--]);
            ++count;
        }
        while (next < arr.length && count < k) {
            list.add(arr[next++]);
            ++count;
        }
        Collections.sort(list);
        return list;
    }

    private int lowerBond(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
