import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (bitCount(h) + bitCount(m) == turnedOn) {
                    String hr = h + ":";
                    String min = (m < 10) ? "0" + m : m + "";
                    list.add(hr + min);
                }
            }
        }
        return list;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
