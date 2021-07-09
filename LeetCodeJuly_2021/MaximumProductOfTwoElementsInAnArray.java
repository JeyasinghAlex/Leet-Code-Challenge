public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second) {
                second = n;
            }
        }
        return (first - 1) * (second - 1);
    }
}
