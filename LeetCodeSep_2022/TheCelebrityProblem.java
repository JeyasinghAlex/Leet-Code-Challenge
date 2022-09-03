import java.util.Stack;

/**
 * Problem link:
 * https://www.codingninjas.com/codestudio/problems/the-celebrity-problem_982769?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
 */
public class TheCelebrityProblem {

    class Runner {
        public static boolean knows(int a, int b) {
            return true;
        }
    }

    public int findCelebrity(int n) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            st.push(i);
        }

        while (st.size() > 1) {

            int a = st.pop();
            int b = st.pop();

            if (Runner.knows(a ,b)) {
                st.push(b);
            } else if (Runner.knows(b, a)) {
                st.push(a);
            }
        }

        if (st.isEmpty()) {
            return -1;
        }

        int celebrity = st.pop();

        for (int i = 0; i < n; ++i) {
            if (i != celebrity && !Runner.knows(i, celebrity)) {
                return -1;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i != celebrity && Runner.knows(celebrity, i)) {
                return -1;
            }
        }
        return celebrity;
    }
}
