public class ReverseInteger {
//    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    public int reverse(int x) {
        int prev = 0;
        int result = 0;
        while (x != 0) {

            int tail = x % 10;
            result = (result * 10) + tail;
            if ((result - tail) / 10 != prev) {
                return 0;
            }
            prev = result;
            x = x / 10;
        }

        return result;
    }
}
