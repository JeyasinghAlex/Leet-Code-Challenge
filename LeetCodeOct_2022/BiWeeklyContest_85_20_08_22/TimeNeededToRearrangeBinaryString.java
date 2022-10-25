package BiWeeklyContest_85_20_08_22;

public class TimeNeededToRearrangeBinaryString {

    public int secondsToRemoveOccurrences(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();
        for (int j = 0; ; ++j) {
            boolean flag = false;
            for (int i = 1; i < n; ++i) {
                if (arr[i - 1] == '0' && arr[i] == '1') {
                    char temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    ++i;
                    flag = true;
                }
            }
            if (!flag) {
                return j;
            }
        }
    }
}
