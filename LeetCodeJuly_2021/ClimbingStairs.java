public class ClimbingStairs {


    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i <= n; ++i) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public int climbStairs_1(int n) {

        if (n == 1) {
            return 1;
        }
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 2;
        return recursive(table, n);

    }

    private int recursive(int[] table, int n) {

        if (table[n] != 0) {
            return table[n];
        }
        table[n] = recursive(table, n - 1) + recursive(table, n - 2);
        return table[n];
    }
}
