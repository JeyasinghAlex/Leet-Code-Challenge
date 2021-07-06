import java.util.PriorityQueue;

public class SecondLargestDigitInString {


    public int secondHighest(String s) {

        int first = -1;
        int second = -1;
        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                int n = ch - '0';
                if (n > first) {
                    second = first;
                    first = n;
                } else if (n > second && n < first) {
                    second = n;
                }
            }
        }
        return second;
    }

    public int secondHighest_1(String s) {

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for (char ch : s.toCharArray()) {

            if (ch >= '0' && ch <= '9' && !qu.contains(ch - '0')) {
                qu.offer(ch - '0');
                if (qu.size() > 2) {
                    qu.poll();
                }
            }
        }
        return qu.size() == 2 ? qu.poll() : -1;
    }
}
