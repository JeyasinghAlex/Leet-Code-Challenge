import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {


    public int numJewelsInStones(String jewels, String stones) {

        int[] cnt = new int[128];
        Set<Character> set = new HashSet<>();
        for (char ch : stones.toCharArray()){
            cnt[ch]++;
        }
        int count = 0;
        for (char ch : jewels.toCharArray()) {
            count += cnt[ch];
        }
        return count;
    }

    public int numJewelsInStones_1(String jewels, String stones) {

        Set<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {

            if (set.contains(ch)) ++count;
        }
        return count;
    }
}
