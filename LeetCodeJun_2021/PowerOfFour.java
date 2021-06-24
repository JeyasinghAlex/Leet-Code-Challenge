public class PowerOfFour {

        public boolean isPowerOfFour(int n) {

            int count = 0;
            int bit = 0;
            while (n > 0) {

                bit++;
                count += n & 1;
                n = n >> 1;
            }

            return count == 1 && bit % 2 == 1;
        }

}
