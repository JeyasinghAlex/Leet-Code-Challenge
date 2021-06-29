public class RotateString {

    public boolean rotateString(String s, String goal) {


        StringBuilder sb = new StringBuilder(s);

        if (s.length() == 0 && goal.length() == 0) {
            return true;
        }
        if (sb.toString().equals(goal) || s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); ++i) {

            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
