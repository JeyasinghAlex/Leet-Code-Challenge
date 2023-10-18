package StackAndQueue;

import java.util.Stack;

public class SortStack {

    public void sortStack(Stack<Integer> st) {

        if (st.isEmpty())
            return;

        int val = st.pop();
        sortStack(st);
        sort(st, val);

    }
    private void sort(Stack<Integer> st, int val) {

        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            int top = st.peek();
            if (val > top)
                break;

            temp.push(st.pop());
        }

        st.push(val);
        while (!temp.isEmpty())
            st.push(temp.pop());

    }
}
