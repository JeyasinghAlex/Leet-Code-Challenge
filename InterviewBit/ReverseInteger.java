package InterviewBit;

public class ReverseInteger {

    public int reverse(int A) {

        int temp = A;
        long reverse = 0;
        A = Math.abs(A);

        while (A != 0) {
            reverse = (reverse * 10) + A % 10;
            A = A / 10;
        }

        if (reverse > Integer.MAX_VALUE)
            return 0;

        return temp > 0 ? (int)reverse : -(int)reverse;
    }
}
