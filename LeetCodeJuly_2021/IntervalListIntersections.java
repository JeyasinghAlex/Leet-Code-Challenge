import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int len1 = firstList.length;
        int len2 = secondList.length;
        int i = 0;
        int j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < len1 && j < len2) {

            if (firstList[i][1] >= secondList[j][0] && secondList[j][1] >= firstList[i][0]) {
                int max = Math.max(firstList[i][0], secondList[j][0]);
                int min = Math.min(firstList[i][1], secondList[j][1]);
                ans.add(new int[]{max, min});
            }

            if (secondList[j][1] > firstList[i][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
