import java.util.LinkedList;

public class NumberOfRecentCalls {

    private LinkedList<Integer> slideWindow;
    public NumberOfRecentCalls() {
        this.slideWindow = new LinkedList<>();
    }

    public int ping(int t) {
        slideWindow.addLast(t);
        while (slideWindow.getFirst() < t - 3000) {
            slideWindow.removeFirst();
        }
        return slideWindow.size();
    }
}
