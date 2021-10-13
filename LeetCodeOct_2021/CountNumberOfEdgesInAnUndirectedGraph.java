import java.util.ArrayList;
import java.util.List;

public class CountNumberOfEdgesInAnUndirectedGraph {

    public int countEdges(int v, List<List<Integer>> adj) {

        int sum = 0;
        for (int i = 0; i < v; ++i) {
            sum += adj.get(i).size();
        }
        return sum;
    }
}
