package InterviewBit;

public class VerifyPrime {

    public int isPrime(int A) {

        if (A == 1)
            return 0;

        for (int i = 2; i < A / 2; ++i) {
            if (A % i == 0)
                return 0;
        }
        return 1;
    }
}
