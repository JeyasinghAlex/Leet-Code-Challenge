import java.util.Stack;

public class OnlineStockSpan {

    static class Node {
        int price;
        int span;

        public Node(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Node> st;
    public OnlineStockSpan() {
        this.st = new Stack<>();
    }

    public int next(int price) {

        int span = 1;
        while (!st.isEmpty() && st.peek().price <= price) {
            span += st.pop().span;
        }
        st.push(new Node(price, span));
        return span;
    }
}
