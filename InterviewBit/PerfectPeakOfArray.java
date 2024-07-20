package InterviewBit;

public class PerfectPeakOfArray {

    public int perfectPeak(int[] A) {

        int n = A.length;
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; ++i)
            a[i] = b[i] = A[i];


        for (int i = 1; i < n; ++i)
            a[i] = Math.max(a[i], a[i - 1]);



        for (int i = n - 2; i >= 0; --i)
            b[i] = Math.min(b[i], b[i + 1]);


        for (int i = 1; i < n - 1; ++i) {
            if (A[i] > a[i - 1] && A[i] < b[i + 1])
                return 1;
        }
        return 0;
    }
}
