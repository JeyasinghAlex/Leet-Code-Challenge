package WeeklyContest_304_31_07_22;

public class MaximumNumberOfGroupsEnteringCompetition {

    public int maximumGroups(int[] grades) {
        int k = 0, total = 0, n = grades.length;
        while (total + k + 1 <= n)
            total += ++k;
        return k;
    }

    public int maximumGroups_1(int[] grades) {

        int n = grades.length;

        int group = 0;
        int cnt = 0;
        int size = 1;

        for (int i = 0; i < n;  ++i) {

            ++cnt;

            if (cnt == size) {
                ++group;
                ++size;
                cnt = 0;
            }
        }
        return group;
    }
}
