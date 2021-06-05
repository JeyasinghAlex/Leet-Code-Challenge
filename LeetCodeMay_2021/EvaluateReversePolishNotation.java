package LeetCodeMay_2021;

import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {

            switch (s) {
                case "+": {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a + b);
                    break;
                }case "-": {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a - b);
                    break;
                }case "*": {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a * b);
                    break;
                }case "/": {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a / b);
                    break;
                } default: {
                    st.push(Integer.parseInt(s));
                }
            }
        }
        return st.pop();
    }
}
