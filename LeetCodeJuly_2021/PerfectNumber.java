public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;

        return sum == num;
    }

    public boolean checkPerfectNumber_1(int num) {

        int sum = 0;
        for (int i = num >> 1; i > 0; --i) {

            if (num % i ==  0) {
                sum += i;
            }

            if (sum == num) {
                return true;
            }
        }
        return false;
    }
}
