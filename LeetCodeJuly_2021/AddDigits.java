public class AddDigits {

    public int addDigits(int num) {
        while (num > 9) {
            num = addDigit(num);
        }
        return num;
    }

    private int addDigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int addDigits_1(int num) {

        if (num == 0) return 0;
        if (num % 9 == 0) return 9;

        return num % 9;
    }
}
