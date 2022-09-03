public class ImplementQueueUsingArray {

    private int[] arr;
    private int front;
    private int rear;
    private int size = 5000;
    int count = 0;

    ImplementQueueUsingArray() {
        // Implement the Constructor
        this.arr = new int[size];
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return count == 0;

    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if (count == size) {
            return;
        }
        ++count;
        arr[rear++ % size] = data;
    }

    int dequeue() {
        // Implement the dequeue() function
        if (count == 0) {
            return -1;
        }
        --count;
        return arr[front++];
    }

    int front() {
        // Implement the front() function
        if (count == 0) {
            return -1;
        }
        return arr[front];
    }
}
