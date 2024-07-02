package InterviewBit;

import java.util.Stack;

public class ParitySwappingIntegerMinimization {

    public String solve(String A) {


        int n = A.length();
        Stack<Character> odd = new Stack<>();
        Stack<Character> even = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {

            char ch = A.charAt(i);
            int num = ch - '0';
            if (num % 2 == 1)
                odd.push(ch);
            else
                even.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!odd.isEmpty() && !even.isEmpty()) {

            if (odd.peek() < even.peek())
                sb.append(odd.pop());
            else
                sb.append(even.pop());
        }

        while (!odd.isEmpty())
            sb.append(odd.pop());

        while (!even.isEmpty())
            sb.append(even.pop());

        return sb.toString();
    }
}
