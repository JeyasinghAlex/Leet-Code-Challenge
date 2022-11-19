package BiWeeklyContest_91_12_11_22;

public class SplitMessageBasedOnLimit {

    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        int cum = 0;
        for(int d = 1;d <= n;d++){
            int len = Integer.toString(d).length() + 3;
            if(len + Integer.toString(d).length() > limit)break;
            cum += Integer.toString(d).length();
            long all = cum + (long)len * d + n;
            if(all <= (long)limit * d){
                String[] ret = new String[d];
                int p = 0;
                for(int j = 1;j <= d;j++){
                    String suf = "<" + j + "/" + d + ">";
                    int rem = limit - suf.length();
                    int to = Math.min(p+rem, n);
                    ret[j-1] = message.substring(p, to) + suf;
                    p = to;
                }
                return ret;
            }
        }
        return new String[0];
    }
}
