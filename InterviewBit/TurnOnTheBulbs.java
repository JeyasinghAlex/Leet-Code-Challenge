package InterviewBit;

public class TurnOnTheBulbs {

    public int solve(int A) {

        int ans = 0;
        int group = A / 6;
        int rem = A % 6;
        int cnt = 0;

        if (rem == 0)
            cnt = 0;
        else if (rem == 1)
            cnt = 1;
        else
            cnt = 2;

        return (group * 2) + cnt;
    }
}
