package InterviewBit;

public class TotalMovesForBishop {

    public int solve(int A, int B) {

        int[][] dir = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        int cnt = 0;
        for (int[] d : dir) {
            int x = A + d[0];
            int y = B + d[1];

            while (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
                ++cnt;
                x += d[0];
                y += d[1];
            }
        }
        return cnt;
    }
}
