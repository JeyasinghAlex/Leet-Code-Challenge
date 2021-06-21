import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }
            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }
        return result;
    }

    public int heightChecker_1(int[] heights) {

        int[] temp = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            temp[i] = heights[i];
        }
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < temp.length; ++i) {
            if (heights[i] != temp[i]) {
                ++count;
            }
        }
        return count;
    }
}
