import java.util.Arrays;

public class MinimumPlatforms {

    public int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 1;
        int platform_needed = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < dep.length) {

            if (arr[i] <= dep[j]) {
                platform_needed++;
                ++i;
            } else {
                platform_needed--;
                ++j;
            }
            max = Math.max(max, platform_needed);
        }
        return max;
    }
}