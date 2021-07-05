import java.util.HashMap;
import java.util.Map;

public class X_OfKindInDeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : deck) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int group = 0;
        for (int n : map.values()) {
            group = group == 0 ? n : gcd(group, n);
        }
        return group >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
