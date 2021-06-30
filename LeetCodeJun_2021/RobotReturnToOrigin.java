public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {

        int u = 0;
        int d = 0;
        int r = 0;
        int l = 0;
        for (char ch : moves.toCharArray()) {

            if (ch == 'U') ++u;
            if (ch == 'D') ++d;
            if (ch == 'R') ++r;
            if (ch == 'L') ++l;

        }
        return u == d && r == l;
    }
}
