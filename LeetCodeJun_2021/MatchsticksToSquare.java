import java.util.Arrays;

public class MatchsticksToSquare {

    public boolean makeSquare(int[] matchsticks) {

        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }

        if (sum % 4 != 0 || matchsticks.length < 4) {
            return false;
        }

        Arrays.sort(matchsticks);
        int side = sum / 4;
        return dfs(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, side);
    }

    private boolean dfs(int[] arr, int index, int side1, int side2, int side3, int side4, int target) {

        if (side1 > target || side2 > target || side3 > target || side4 > target) {
            return false;
        }

        if (index < 0) {
            if (side1 == target && side2 == target && side3 == target && side4 == target) {
                return true;
            }
            return false;
        }

        return dfs(arr, index - 1, side1 + arr[index], side2, side3, side4, target) ||
                dfs(arr, index - 1, side1, side2 + arr[index], side3, side4, target) ||
                dfs(arr, index - 1, side1, side2, side3 + arr[index], side4, target) ||
                dfs(arr, index - 1, side1, side2, side3, side4 + arr[index], target);

    }
}
