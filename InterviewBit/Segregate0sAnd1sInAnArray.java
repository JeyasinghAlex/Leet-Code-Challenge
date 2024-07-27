package InterviewBit;

public class Segregate0sAnd1sInAnArray {

    public int[] solve(int[] A) {

        int n = A.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {

            while (i < j && A[i] == 0)
                ++i;

            while (i < j && A[j] == 1)
                --j;

            A[i] = 0;
            A[j] = 1;
        }
        return A;
    }

    public int[] solve_1(int[] A) {

        int n = A.length;
        int zero = 0;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
                ++zero;
        }

        for (int i = 0; i < zero; ++i)
            A[i] = 0;

        for (int i = zero; i < n; ++i)
            A[i] = 1;

        return A;
    }
}
