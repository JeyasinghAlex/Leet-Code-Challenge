public class CheckIfAllAsAppearsBeforeAllBs {

    public boolean checkString(String s) {

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }

    public boolean checkString_1(String s) {

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == 'a') {
            ++i;
        }

        while (i < n && s.charAt(i) == 'b') {
            ++i;
        }

        return i == n;
    }
}
