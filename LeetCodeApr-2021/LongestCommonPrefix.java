public class LongestCommonPrefix {


//    Approach 1: Horizontal scanning
    public String longestCommonPrefixx(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }


//    Approach 3: Divide and conquer
    public String longestCommonPre(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }
        char[] ch = strs[0].toCharArray();
        String ans = "";
        for (int i = 1; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            ans = "";
            int len = Math.min(ch.length, chars.length);
            for (int j = 0; j < len; ++j) {
                if (ch[j] == chars[j]) {
                    ans += chars[j];
                } else {
                    break;
                }
            }
            ch = ans.toCharArray();
        }
        return ans;
    }
}
