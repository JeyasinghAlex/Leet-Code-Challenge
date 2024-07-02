package InterviewBit;

public class MinStepsInInfiniteGrid {

    public int coverPoints(int[] A, int[] B) {

        int n = A.length;
        int minStep = 0;
        for (int i = 0; i < n - 1; ++i) {
            minStep += getMinStep(i, i + 1, A, B);
        }
        return minStep;
    }

    private int getMinStep(int i, int j, int[] A, int[] B) {

        int x1 = A[i];
        int y1 = B[i];

        int x2 = A[j];
        int y2 = B[j];

        int max1 = Math.abs(x1 - x2);
        int max2 = Math.abs(y1 - y2);

        return Math.max(max1, max2);
    }
}
