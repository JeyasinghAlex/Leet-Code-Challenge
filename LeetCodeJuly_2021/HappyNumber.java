import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


    public boolean isHappy(int n) {

        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSqrSum(slow);
            fast = digitSqrSum(fast);
            fast = digitSqrSum(fast);
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int digitSqrSum(int n) {

        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy_1(int n) {

        Set<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int sqrSum = 0;
            while (n > 0) {
                int rem = n % 10;
                sqrSum += rem * rem;
                n /= 10;
            }
            if (sqrSum == 1) {
                return true;
            }
            n = sqrSum;
        }
        return false;
    }

    public boolean isHappy_2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int temp = 0;
        while (n > 0) {

            int rem = n % 10;
            temp += rem * rem;
            n /= 10;

            if (n == 0) {
                if (temp == 1) {
                    return true;
                }
                if (set.contains(temp)) {
                    return false;
                }
                set.add(temp);
                n = temp;
                temp  = 0;
            }
        }
        return false;
    }
}
