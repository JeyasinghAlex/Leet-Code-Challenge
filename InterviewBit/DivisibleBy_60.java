package InterviewBit;

public class DivisibleBy_60 {

    public int divisibleBy60(int[] A) {

        boolean hasZero = false;
        boolean hasEven = false;
        boolean isDivideByThree = false;
        int sum = 0;
        int n = A.length;
        if (n == 1 && A[0] == 0)
            return 1;

        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
                hasZero = true;
            else if (A[i] % 2 == 0)
                hasEven = true;

            sum += A[i];
        }

        if (hasZero && hasEven && sum % 3 == 0)
            return 1;
        return 0;
    }
}
