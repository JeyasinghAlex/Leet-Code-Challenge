import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(ans, list, graph, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int[][] graph, int node) {

        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int a : graph[node]) {
            list.add(a);
            dfs(ans, list, graph, a);
            list.remove(list.size() - 1);
        }
    }
}
