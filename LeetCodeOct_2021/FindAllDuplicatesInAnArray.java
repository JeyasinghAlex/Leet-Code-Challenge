import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            int temp = Math.abs(n) - 1;
            if (nums[temp] < 0) {
                list.add(temp + 1);
            } else {
                nums[temp] = -nums[temp];
            }
        }
        return list;
    }

    public List<Integer> findDuplicates_1(int[] nums) {

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[100001];

        for (int n : nums) {
            if (visited[n]) {
                list.add(n);
            }
            visited[n] = true;
        }
        return list;
    }
}
