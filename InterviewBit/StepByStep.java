package InterviewBit;

public class StepByStep {

    public int solve(int A) {

        A = Math.abs(A);

        int sum = 0;
        int step = 1;

        while (sum < A) {
            sum += step;
            ++step;
        }

        while ((sum - A) % 2 != 0) {
            sum += step;
            ++step;
        }
        return step - 1;
    }
}
