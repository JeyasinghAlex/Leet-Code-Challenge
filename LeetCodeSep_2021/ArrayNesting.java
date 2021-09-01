
public class ArrayNesting {

    public int arrayNesting(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        int count = 0;
        int res = 0;
        for (int i : nums) {

            count = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                ++count;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}