public class UglyNumber {

    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }
        int[] prim = new int[]{2, 3, 5};
        for (int num : prim) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
