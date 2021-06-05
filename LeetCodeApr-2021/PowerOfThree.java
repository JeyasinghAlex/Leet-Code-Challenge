public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

//        if (n <= 0) {
//            return false;
//        }

        while (1 < n) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}
