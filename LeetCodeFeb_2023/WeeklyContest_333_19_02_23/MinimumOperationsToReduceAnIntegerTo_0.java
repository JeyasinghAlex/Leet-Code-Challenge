package WeeklyContest_333_19_02_23;

public class MinimumOperationsToReduceAnIntegerTo_0 {

    public int minOperations(int n) {
        if (n == 0)
            return 0;

        if (n % 4 == 3)
            return 1 + minOperations(n+1);

        if ( n % 4 == 1)
            return 1 + minOperations(n-1);

        return minOperations(n/2);
    }
}
