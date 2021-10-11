import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[v];
        boolean[] back = new boolean[v];
        for (int i = 0; i < v; ++i) {

            if (!visited[i]) {
                boolean flag = isCyclicUtil(visited, back, i, adj);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(boolean[] visited, boolean[] back, int curr, List<ArrayList<Integer>> adj) {

        visited[curr] = true;
        back[curr] = true;

        List<Integer> list = adj.get(curr);
        for (int i : list) {

            if (!visited[i] && !back[i]) {
                boolean flag = isCyclicUtil(visited, back, i, adj);
                if (flag) {
                    return true;
                }
            } else if (back[i]) {
                return true;
            }
        }
        back[curr] = false;
        return false;
    }
}
