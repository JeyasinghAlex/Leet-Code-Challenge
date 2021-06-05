import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {


    public static void main(String[] args) {
        int[][] q = new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(arr, q)));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[A.length];
        int sum = 0;
        for (int a : A) {
            sum += a % 2 == 0 ? a : 0;
        }

        for (int i = 0; i  < queries.length; ++i) {
            int index = queries[i][1];
            int val = queries[i][0];

            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += val;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            answer[i] = sum;

        }
        return answer;
    }
}
