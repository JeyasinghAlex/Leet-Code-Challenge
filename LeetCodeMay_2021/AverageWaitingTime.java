package LeetCodeMay_2021;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double waitingTime = 0;

        for (int[] arr : customers) {
            time = arr[0] > time ? arr[0] : time;
            time += arr[1];
            waitingTime += time - arr[0];
        }

        return waitingTime / customers.length;
    }
}
