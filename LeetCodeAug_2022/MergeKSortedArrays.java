import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {

    public static List<Integer> mergeKSortedArrays(ArrayList<List<Integer>> kArrays, int k) {

        Queue<Integer> qu = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> list : kArrays) {
            for (int n : list) {
                qu.offer(n);
            }
        }

        while (!qu.isEmpty()) {
            ans.add(qu.poll());
        }
        return ans;
    }
}
