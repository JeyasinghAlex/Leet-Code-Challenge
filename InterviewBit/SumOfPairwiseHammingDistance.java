package InterviewBit;

public class SumOfPairwiseHammingDistance {

    public int hammingDistance(final int[] A) {

        int n = A.length;
        long ans = 0;
        int MOD = 1000000007;
        for (int i = 0; i < 32; ++i) {
            long cntOne = 0;
            long cntZero = 0;

            for (int x : A) {
                if (((1 << i) & x) != 0)
                    ++cntOne;
                else
                    ++cntZero;
            }

            ans = (ans + (2 * cntOne * cntZero) % MOD) % MOD;
        }
        return (int)ans;
    }
}
