public class PushDominoesSolution {

    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        int[] left = new int[n];
        int nearestLeftIndex = -1;
        for (int i = n - 1; i >= 0; --i) {

            char ch = dominoes.charAt(i);
            if (ch == 'L') {
                nearestLeftIndex = i;
            }else if (ch == 'R') {
                nearestLeftIndex = -1;
            }
            left[i] = nearestLeftIndex;
        }

        int[] right = new int[n];
        int nearestRightIndex = -1;
        for (int i = 0; i < n; ++i) {

            char ch = dominoes.charAt(i);
            if (ch == 'R') {
                nearestRightIndex = i;
            } else if (ch == 'L') {
                nearestRightIndex = -1;
            }
            right[i] = nearestRightIndex;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {

            char ch = dominoes.charAt(i);
            if (ch == '.') {
                int nearestLeft = left[i];
                int nearestRight = right[i];
                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);
                if (leftDiff == rightDiff) {
                    sb.append('.');
                } else if (leftDiff < rightDiff) {
                    sb.append('L');
                } else  {
                    sb.append('R');
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}