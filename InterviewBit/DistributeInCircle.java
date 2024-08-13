package InterviewBit;

public class DistributeInCircle {

    public int solve(int A, int B, int C) {
        int val = A % B;
        return (val + C % B - 1) % B;
    }
}
