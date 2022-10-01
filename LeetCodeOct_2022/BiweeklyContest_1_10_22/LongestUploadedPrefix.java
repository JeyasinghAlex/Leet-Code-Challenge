package BiweeklyContest_1_10_22;

public class LongestUploadedPrefix {

    private boolean[] arr;
    private static int start;
    public LongestUploadedPrefix(int n) {
        start = 1;
        this.arr = new boolean[n + 1];
    }

    public void upload(int video) {
        arr[video] = true;
    }

    public int longest() {

        int count = 0;
        for (int i = start; i < arr.length; ++i) {
            if (arr[i]) {
                start = i;
            } else {
                return i - 1;
            }
        }
        return start;
    }
}
