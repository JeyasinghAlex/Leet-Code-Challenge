package BiWeeklyContest_80_11_06_22;

public class StrongPasswordChecker_II {

    public boolean strongPasswordCheckerII(String password) {

        int n = password.length();
        if (n < 8) {
            return false;
        }
        boolean isLower = false;
        boolean isUpper = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        String special = "!@#$%^&*()-+";

        for (int i = 0; i < n; ++i) {
            char ch = password.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                isLower = true;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                isUpper = true;
            }
            else if (ch >= '0' && ch <= '9') {
                isDigit = true;
            }
            else if (special.contains(ch + "")) {
                isSpecial = true;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }
        return isLower && isUpper && isDigit && isSpecial;
    }
}
