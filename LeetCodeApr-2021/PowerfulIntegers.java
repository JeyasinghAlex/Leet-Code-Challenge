import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int i = 1, ans = 1;
        if (x != 1)
            while (ans <= bound) {
                list1.add(ans);
                ans = pow(x, i++);
            }

        i = 1;
        ans = 1;
        if (y != 1)
            while (ans <= bound) {
                list2.add(ans);
                ans = pow(y, i++);
            }

        list1.add(1);
        list2.add(1);

        for (int powOfX : list1) {
            for (int powOfY : list2) {
                if (powOfX + powOfY <= bound && !res.contains(powOfX + powOfY)) {
                    res.add(powOfX + powOfY);
                }
            }
        }
        return res;

    }

    //    OR use Math.pow(base, exponent);
    private int pow(int base, int exponent) {
        int ans = 1;
        for (; exponent != 0; --exponent) {
            ans *= base;
        }
        return ans;
    }


    public List<Integer> powerfulInteger(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                if (i + j <= bound) {
                    set.add(i + j);
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

    public List<Integer> powerfulIntege(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        int X = (int) (x == 1 ? 0 : Math.log(bound) / Math.log(x));
        int Y = (int) (y == 1 ? 0 : Math.log(bound) / Math.log(y));
        for(int i=0; i<=X; i++) {
            for(int j=0; j<=Y; j++) {
                int value = (int) (Math.pow(x, i) + Math.pow(y, j));
                if(value <= bound){
                    set.add(value);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
