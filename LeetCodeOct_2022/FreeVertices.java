public class FreeVertices {
    static int freeVertices(int n, int m) {

        for (int i = 0; i <= n; ++i) {

            int x = (i * (i - 1) / 2); // possible edges in i vertex

            if (x >= m) {
                return n - i;
            }
        }
        return -1;
    }
}
