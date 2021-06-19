public class SortArrayByParity_II {

    public int[] sortArrayByParityII(int[] nums) {

        int[] res = new int[nums.length];
        int i = 0;
        int j = 1;
        for (int a : nums) {
            if (a % 2 == 0) {
                res[i] = a;
                i = i + 2;
            } else {
                res[j] = a;
                j = j + 2;
            }
        }
        return res;
    }
}
