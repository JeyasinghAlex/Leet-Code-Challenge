package InterviewBit;

public class NextSimilarNumber {

    public String solve(String A) {


        int peek = indexOfLastPeek(A) - 1;
        if (peek == -1) {
            return "-1";
        }

        char[] arr = A.toCharArray();
        int idx = nextGrater(A, A.charAt(peek));
        swap(arr, peek, idx);

        reverse(arr, peek + 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int i) {

        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            ++i;
            --j;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int nextGrater(String s, char ch) {

        int n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) > ch) {
                return i;
            }
        }
        return 0;
    }

    private int indexOfLastPeek(String s) {

        int n = s.length();
        for (int i = n - 1; i > 0; --i) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                return i;
            }
        }
        return 0;
    }
}
