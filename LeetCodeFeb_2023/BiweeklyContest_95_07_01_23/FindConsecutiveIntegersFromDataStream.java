package BiweeklyContest_95_07_01_23;

public class FindConsecutiveIntegersFromDataStream {

    private int value;
    private int k;
    private int count;

    public FindConsecutiveIntegersFromDataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {

        count = num == value ? count + 1 : 0;

        return count >= k;
    }
}
