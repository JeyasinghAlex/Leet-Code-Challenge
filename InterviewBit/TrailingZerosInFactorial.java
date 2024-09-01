package InterviewBit;

public class TrailingZerosInFactorial {

    public int trailingZeroes(int A) {

        int base = 5;
        int cnt = 0;
        while ((A / base) >= 1) {
            cnt += A / base;
            base *= 5;
        }

        return cnt;
    }
}
