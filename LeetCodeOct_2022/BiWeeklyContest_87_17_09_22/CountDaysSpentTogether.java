package BiWeeklyContest_87_17_09_22;

public class CountDaysSpentTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i] + arr[i - 1];
        }

        String[] aliceArrive = arriveAlice.split("-");
        String[] aliceLeave = leaveAlice.split("-");
        String[] bobArrive = arriveBob.split("-");
        String[] bobLeave = leaveBob.split("-");

        int aliceArriveMonth = Integer.parseInt(aliceArrive[0]) - 1;
        int aliceArriveDate = arr[aliceArriveMonth] + Integer.parseInt(aliceArrive[1]);
        int aliceLeaveMonth = Integer.parseInt(aliceLeave[0]) - 1;
        int aliceLeaveDate = arr[aliceLeaveMonth] + Integer.parseInt(aliceLeave[1]);

        int bobArriveMonth = Integer.parseInt(bobArrive[0]) - 1;
        int bobArriveDate = arr[bobArriveMonth] + Integer.parseInt(bobArrive[1]);
        int bobLeaveMonth = Integer.parseInt(bobLeave[0]) - 1;
        int bobLeaveDate = arr[bobLeaveMonth] + Integer.parseInt(bobLeave[1]);

        if (aliceArriveDate > bobLeaveDate || bobArriveDate > aliceLeaveDate) {
            return 0;
        }

        int start = Math.max(aliceArriveDate, bobArriveDate);
        int end = Math.min(aliceLeaveDate, bobLeaveDate);

        int cnt = 0;
        for (int i = start; i <= end; ++i) {
            ++cnt;
        }
        return cnt;

    }
}
