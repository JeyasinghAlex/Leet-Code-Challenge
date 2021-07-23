public class JumpGame_III {

    private boolean res = false;

    public boolean canReach(int[] arr, int start) {
        dfs(arr, start);
        return res;
    }

    private boolean dfs(int[] arr, int idx) {

        if (idx < 0 || idx >= arr.length || arr[idx] == -1) {
            return false;
        }
        int val = arr[idx];
        arr[idx] = -1;
        return val == 0 || dfs(arr, idx - val) || dfs(arr, idx + val);

    }


    private void dfs_1(int[] arr, int idx) {

        if (idx < 0 || idx >= arr.length || arr[idx] == -1) {
            return ;
        }

        if (arr[idx] == 0) {
            res = true;
            return ;
        }

        int index = arr[idx];
        arr[idx] = -1;
        dfs(arr, idx - index);
        dfs(arr, idx + index);

    }

    private void dfs(int[] arr, int idx, boolean[] visited) {

        if (idx < 0 || idx >= arr.length || visited[idx]) {
            return ;
        }

        if (arr[idx] == 0) {
            res = true;
            return ;
        }

        visited[idx] = true;
        dfs(arr, idx - arr[idx], visited);
        dfs(arr, idx + arr[idx], visited);
    }
}
