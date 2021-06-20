import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RankTransformOfAnArray {


    public int[] arrayRankTransform(int[] arr) {

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }


    public int[] arrayRankTransform_1(int[] arr) {

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            qu.offer(a);
        }

        int rank = 1;
        while (!qu.isEmpty()) {
            int mark = qu.poll();
            if (!map.containsKey(mark)) {
                map.put(mark, rank++);
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
