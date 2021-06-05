import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {

//    Approach #2 (Sorting) [Accepted]
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

//    Approach #3 (List) [Accepted]
    public boolean containDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
        }
        return false;
    }
}
