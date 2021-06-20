import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] cnt = new int[1001];
        for (int a : arr1) {
            cnt[a]++;
        }

        int idx = 0;
        for (int a : arr2) {

            while (cnt[a]-- > 0) {
                arr1[idx++] = a;
            }

        }

        for (int i = 0; i < 1001; ++i) {
            while (cnt[i]-- > 0) {
                arr1[idx++] = i;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray_1(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int a : arr1) {
            int count = map.getOrDefault(a, 0) + 1;
            map.put(a , count);
        }

        int idx = 0;
        for (int a : arr2) {

            for (int i = 0; i < map.get(a); ++i) {
                arr1[idx++] = a;
            }
            map.remove(a);
        }

        for (int a : map.keySet()) {
            for (int i = 0; i < map.get(a); ++i) {
                arr1[idx++] = a;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray_2(int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();
        for (int a : arr1) {
            list.add(a);
        }
        list.sort((a, b) -> a - b);

        int idx = 0;
        for (int a : arr2) {
            while (list.contains(a)) {
                int index = list.indexOf(a);
                arr1[idx++] = list.remove(index);
            }
        }

        while (!list.isEmpty()) {
            arr1[idx++] = list.remove(0);
        }
        return arr1;
    }
}
