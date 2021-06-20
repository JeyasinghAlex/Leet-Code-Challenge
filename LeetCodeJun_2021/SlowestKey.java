public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int len = releaseTimes.length;
        int[] time = new int[26];
        int max = Integer.MIN_VALUE;
        int prevTime = 0;
        char ch = 'A';
        for (int i = 0; i < len; ++i) {
            int t = releaseTimes[i] - prevTime;
            prevTime = releaseTimes[i];
            if(t > time[keysPressed.charAt(i) - 'a']) {
                time[keysPressed.charAt(i) - 'a'] = t;
            }
            if (t > max || t == max && keysPressed.charAt(i) > ch) {
                ch = keysPressed.charAt(i);
            }
            max = Math.max(t, max);
        }
        return ch;
    }
}
