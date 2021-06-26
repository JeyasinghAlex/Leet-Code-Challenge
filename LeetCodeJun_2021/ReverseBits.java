public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int ans = 0;
        int pow = 31;
        while (n != 0) {

            int bit = (n & 1);
            ans = ans | (bit << pow);
            n >>>= 1;
            --pow;
        }
        return ans;
    }
}
