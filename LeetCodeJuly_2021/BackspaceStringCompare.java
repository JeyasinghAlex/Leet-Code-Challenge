public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        return shrink(s).equals(shrink(t));
    }

    private String shrink(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            } else if (sb.length() > 0){
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
