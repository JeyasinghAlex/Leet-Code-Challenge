import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for(int i = 0;i < nodeCount;i++){
            boolean flag = dfs(graph, i, color);
            if(flag)   {
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0)   {
            return color[start] == 1;
        }

        color[start] = 2;
        for(int newNode : graph[start]){
            boolean flag = dfs(graph, newNode, color);
            if(!flag) {
                return false;
            }
        }
        color[start] = 1;
        return true;
    }
}
