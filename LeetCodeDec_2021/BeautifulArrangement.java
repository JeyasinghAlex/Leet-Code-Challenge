public class BeautifulArrangement {

    int count = 0;
    public int countArrangement(int n) {

        boolean[] visited = new boolean[n + 1];
        backtrack(visited, 1, n);
        return count;
    }

    private void backtrack(boolean[] visited, int pos, int n) {

        if (pos > n) {
            ++count;
        }

        for (int i = 1; i <= n; ++i) {

            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                backtrack(visited, pos + 1, n);
                visited[i] = false;
            }
        }
    }
}