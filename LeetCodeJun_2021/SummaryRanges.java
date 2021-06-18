import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {


        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {

            int temp = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                ++i;
            }

            if (temp != nums[i]) {
                list.add(temp + "->" + nums[i]);
            } else {
                list.add(temp + "");
            }
        }
        return list;
    }
}
