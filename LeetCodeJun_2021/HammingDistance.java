public class HammingDistance {


    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        while (xor != 0) {
            count += (xor & 1);
            xor >>>= 1;
        }
        return count;
    }

    public int hammingDistance_1(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            int a = x == 0 ? 0 : x & 1;
            x >>>= 1;
            int b = y == 0 ? 0 : y & 1;
            y >>>= 1;

            if (a != b) {
                ++count;
            }
        }
        return count;
    }
}
