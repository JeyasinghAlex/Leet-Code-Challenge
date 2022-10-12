package WeeklyContest_311_18_09_22;

public class SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {

        if (n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }

    public int smallestEvenMultiple_1(int n) {
        for (int i = 1; ; ++i) {
            if (i % 2 == 0 && i % n == 0) {
                return i;
            }
        }
    }
}
