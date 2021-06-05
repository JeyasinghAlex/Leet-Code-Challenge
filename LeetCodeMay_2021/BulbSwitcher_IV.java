package LeetCodeMay_2021;

public class BulbSwitcher_IV {

    public int minFlips(String target) {

        int state = 0, count = 0;
        for (char ch : target.toCharArray()) {
            if (ch - '0' != state) {
                state = ch - '0';
                ++count;
            }
        }
        return count;
    }
}
