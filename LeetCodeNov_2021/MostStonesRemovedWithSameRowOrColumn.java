import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

    private int[] parent;
    public int removeStones(int[][] stones) {

        int len = stones.length;

        int max = Integer.MIN_VALUE;

        for (int[] stone : stones) {
            max = Math.max(max, stone[0]);
            max = Math.max(max, stone[1]);
        }

        parent = new int[1000];
        for (int i = 0; i < len; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < len; ++i) {
            if (parent[i] == i) {
                ++ans;
            }
        }
        return stones.length - ans;
    }

    private int find(int v) {

        if (parent[v] == v) {
            return v;
        }
        return find(parent[v]);
    }

    private void union(int u, int v) {

        int a = find(u);
        int b = find(v);
        if (a != b) {
            parent[b] = a;
        }
    }


    public int removeStones_1(int[][] stones) {

        int len = stones.length;
        int numberOfIsland = 0;
        Set<int[]> visited = new HashSet<>();

        for (int[] stone : stones) {

            if (!visited.contains(stone)) {
                dfs(stone, stones, visited);
                ++numberOfIsland;
            }
        }
        return len - numberOfIsland;
    }

    private void dfs(int[] st, int[][] stones, Set<int[]> visited) {

        visited.add(st);

        for (int[] stone : stones) {

            if (!visited.contains(stone)) {

                if (st[0] == stone[0] || st[1] == stone[1]) {
                    dfs(stone, stones, visited);
                }
            }
        }
    }
}
