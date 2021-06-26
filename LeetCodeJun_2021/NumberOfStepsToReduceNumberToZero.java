public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int n) {

        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                n = n - 1;
            } else {
                n >>= 1;
            }
            ++count;
        }
        return count;
    }
}
