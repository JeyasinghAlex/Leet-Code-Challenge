package InterviewBit;

public class Seats {

    public int seats(String A) {


        int totalX = 0;
        int leftX = 0;
        long ans = 0;
        long MOD = 10000003;
        for (char ch : A.toCharArray()) {
            if (ch == 'x')
                ++totalX;
        }

        for (char ch : A.toCharArray()) {
            if (ch == 'x')
                ++leftX;
            else
                ans = (ans + (Math.min(leftX, totalX - leftX))) % MOD;
        }

        return (int) ans;

    }
}
