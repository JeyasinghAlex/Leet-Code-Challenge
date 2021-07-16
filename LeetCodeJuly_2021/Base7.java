public class Base7 {

    public String convertToBase7(int num) {
        int base = 1;
        int res = 0;
        while (num != 0) {

            res += base * (num % 7);
            num /= 7;
            base *= 10;
        }
        return String.valueOf(res);
    }
}
