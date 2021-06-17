public class MajorityElement {

    public int majorityElement(int[] nums) {

        int count = 0;
        int mejority = 0;
        for (int num : nums) {
            if (count == 0) {
                ++count;
                mejority = num;
            } else if (num == mejority) {
                ++count;
            } else {
                --count;
            }
        }
        return mejority;
    }
}
