public class Pow_x_n {

    public double myPow(double x, int n) {

        long pow = n;
        pow = pow > 0 ? pow : -pow;
        double ans = 1.0;

        while (pow > 0) {

            if (pow % 2 == 0) {
                x = x * x;
                pow = pow / 2;
            } else {
                ans = ans * x;
                pow--;
            }
        }

        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

    public double myPow_1(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double pow = myPow_1(x, n / 2);

        if (n % 2 == 0) {
            return pow * pow;
        }

        if (n > 0) {
            return pow * pow * x;
        } else {
            return pow * pow / x;
        }
    }
}
