package Heaps;

import java.util.*;

public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {

        Queue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (List<Integer> list : kArrays) {
            for (int n : list) {
                pq.offer(n);
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }

}
