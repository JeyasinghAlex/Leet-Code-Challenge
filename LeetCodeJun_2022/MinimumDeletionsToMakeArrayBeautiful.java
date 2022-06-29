import java.util.ArrayList;
import java.util.List;

public class MinimumDeletionsToMakeArrayBeautiful {

    public int minDeletion(int[] nums) {

        int count = 0;
        int n = nums.length;
        int newIndex = 0;
        for (int i = 0; i < n - 1; ++i) {
            newIndex = i - count;
            if (newIndex % 2 == 0 && nums[i] == nums[i + 1]) {
                ++count;
            }
        }

        if ((n - count) % 2 == 1) {
            return count + 1;
        }
        return count;
    }


    public int minDeletion_1(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int count = 0;

        for(int i : nums) {
            result.add(i);
        }

        for(int i = 0; i < result.size() - 1; ++i){
            int x = result.get(i);
            int y = result.get(i+1);
            if(i % 2 == 0 && x == y){
                result.remove(i);
                count++;
                i = i - 1;
            }
        }

        if(result.size() % 2 == 0)
            return count;
        return count+1;
    }
}
