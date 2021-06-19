public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int a : nums) {

            if (a % 2 == 0) {
                res[i++] = a;
            } else {
                res[j--] = a;
            }
        }
        return res;
    }
}
