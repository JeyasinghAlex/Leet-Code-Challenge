package WeeklyContest_316_23_10_22;

public class DetermineIfTwoEventsHaveConflict {

    public boolean haveConflict(String[] event1, String[] event2) {

        String[] t1 = event1[0].split(":");
        int a = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
        String[] t2 = event1[1].split(":");
        int b = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);

        String[] t3 = event2[0].split(":");
        int c = Integer.parseInt(t3[0]) * 60 + Integer.parseInt(t3[1]);
        String[] t4 = event2[1].split(":");
        int d = Integer.parseInt(t4[0]) * 60 + Integer.parseInt(t4[1]);

        if (c > b || a > d) {
            return false;
        }
        return true;
    }
}
