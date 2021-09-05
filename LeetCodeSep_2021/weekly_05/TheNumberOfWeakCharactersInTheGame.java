package weekly_05;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int count = 0;
        int max = 0;
        for (int[] arr : properties) {

            count += max > arr[1] ? 1 : 0;
            max = Math.max(max, arr[1]);
        }
        return count;
    }
}
