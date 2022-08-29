import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    private Queue<Integer> maxHeap; // Store min -> max
    private Queue<Integer> minHeap; // Store max -> min

    public FindMedianFromDataStream() {
        this.maxHeap = new PriorityQueue<>();
        this.minHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
