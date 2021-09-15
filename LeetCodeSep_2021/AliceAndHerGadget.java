public class AliceAndHerGadget {

    public int method(int l, String n) {
        String[] str = {"1111110", "0110000", "1101101", "1111001", "0110011", "1011011", "0011111", "1110000", "1111111", "1110011"};
        String base = "0000000";
        int count = 0;
        for (int i = 0; i < n.length(); ++i) {
            int idx = n.charAt(i) - '0';
            for (int j = 0; j < base.length(); ++j) {
                int a = base.charAt(j) - '0';
                int b = str[idx].charAt(j) - '0';
                if (a != b) {
                    ++count;
                }
            }
            base = str[idx];
        }
        return count;
    }
}
