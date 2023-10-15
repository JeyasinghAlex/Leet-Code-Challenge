package Arrays;

public class Pow_X_N {

    public double myPow(double x, int n) {

        long pow = n;
        pow = pow > 0 ? pow : -pow;
        double ans = 1.0;

        while (pow > 0) {
            if (pow % 2 == 0){
                x = x * x;
                pow = pow / 2;
            }
            else {
                ans = ans * x;
                pow--;
            }
        }

        if (n < 0)
            ans = 1.0 / ans;

        return ans;
    }
}
