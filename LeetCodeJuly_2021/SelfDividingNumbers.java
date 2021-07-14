import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; ++i) {

            if (i % 10 != 0 && isSelfDivided(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDivided(int num) {
        int n = num;
        while (n > 0) {
            int rem = n % 10;
            if (rem == 0 || num % rem != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
