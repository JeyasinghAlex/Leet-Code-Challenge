public class NthRootOf_M {

    public double findNthRootOfM(int n, int m) {
        return getNthRoot(n, m);
    }

    private double getNthRoot(int n, int m) {

        double lo = 1;
        double hi = m;
        double eps = 1e-8;

        while ((hi - lo) > eps) {

            double mid = (lo + hi) / 2.0;

            double mul = multiply(mid, n);

            if (mul < m) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private double multiply(double num, int n) {

        double ans = 1.0;

        for (int i = 1; i <= n; ++i) {
            ans = ans * num;
        }
        return ans;
    }
}
