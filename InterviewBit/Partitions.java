package InterviewBit;

public class Partitions {

    public int solve(int A, int[] B) {

        int n = B.length;
        int[] prefSum = new int[n];
        prefSum[0] = B[0];
        for (int i = 1; i < n; ++i) {
            prefSum[i] = prefSum[i - 1] + B[i];
        }

        int sum = prefSum[n -1];
        if (sum % 3 != 0)
            return 0;

        int partition = sum / 3;
        int cnt = 0;

        for (int i = 0; i < n - 2; ++i) {
            if (prefSum[i] == partition) {
                for (int j = i + 1; j < n - 1; ++j) {
                    if (prefSum[j] - prefSum[i] == partition) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
}
