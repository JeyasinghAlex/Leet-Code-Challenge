public class AddingBinaryToString {

    public int addingBinaryToString(String a, String b) {

        if (a.length() > b.length()) {
            return 0;
        }

        int aZeroCnt = 0;
        int bZeroCnt = 0;
        int aOneCnt = 0;
        int bOneCnt = 0;

        for (char ch : a.toCharArray()) {
            if (ch == '0') {
                ++aZeroCnt;
            } else {
                ++aOneCnt;
            }
        }

        for (char ch : b.toCharArray()) {
            if (ch == '0') {
                ++bZeroCnt;
            } else {
                ++bOneCnt;
            }
        }

        return (aZeroCnt <= bZeroCnt) && (aOneCnt <= bOneCnt) ? 1 : 0;
    }
}
