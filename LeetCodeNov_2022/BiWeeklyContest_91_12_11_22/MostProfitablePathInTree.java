package BiWeeklyContest_91_12_11_22;

import java.util.Arrays;

public class MostProfitablePathInTree {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        int[][] g = packU(n, edges);
        int[][] pars = parents(g, 0);
        int[] par = pars[0], ord = pars[1], dep = pars[2];
        int u = bob;
        for(int i = 0;i < (dep[bob]+1)/2;i++){
            amount[u] = 0;
            u = par[u];
        }
        if(dep[bob] % 2 == 0){
            amount[u] /= 2;
        }
        int[] dp = new int[n];
        for(int i = n-1;i >= 0;i--){
            int cur = ord[i];
            if(g[cur].length == 1 && i > 0) {
                dp[cur] = amount[cur];
            }else{
                dp[cur] = Integer.MIN_VALUE / 2;
                for(int e : g[cur]){
                    if(par[cur] == e){
                        continue;
                    }
                    dp[cur] = Math.max(dp[cur], dp[e] + amount[cur]);
                }
            }
        }
        return dp[0];
    }

    public int[][] parents(int[][] g, int root) {
        int n = g.length;
        int[] par = new int[n];
        Arrays.fill(par, -1);

        int[] depth = new int[n];
        depth[0] = 0;

        int[] q = new int[n];
        q[0] = root;
        for (int p = 0, r = 1; p < r; p++) {
            int cur = q[p];
            for (int nex : g[cur]) {
                if (par[cur] != nex) {
                    q[r++] = nex;
                    par[nex] = cur;
                    depth[nex] = depth[cur] + 1;
                }
            }
        }
        return new int[][]{par, q, depth};
    }

    public int[][] packU(int n, int[][] ft) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for(int[] u : ft){
            p[u[0]]++; p[u[1]]++;
        }
        for(int i = 0;i < n;i++)g[i] = new int[p[i]];
        for(int[] u : ft){
            g[u[0]][--p[u[0]]] = u[1];
            g[u[1]][--p[u[1]]] = u[0];
        }
        return g;
    }
}
