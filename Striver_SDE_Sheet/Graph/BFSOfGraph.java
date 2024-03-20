package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {

    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(0);

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            ans.add(curr);
            visited[curr] = true;
            for(int next : adj.get(curr)) {
                if (!visited[next]) {
                    qu.offer(next);
                    visited[next] = true;
                }
            }
        }

        return ans;
    }
}
