package LeetCodeMay_2021;

public class BulbSwitcher {

    public int bulbSwitch(int n) {

        int i = 1;
        for (; i * i <= n; ++i);

        return i - 1;
    }
}
