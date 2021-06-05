package LeetCodeMay_2021.BiWeekly;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatReservationManager {

    private Queue<Integer> qu;
    boolean[] seat;
    public SeatReservationManager(int n) {
        seat = new boolean[n];
        qu   = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            qu.add(i);
        }
    }

    public int reserve() {
        if (qu.isEmpty()) {
            return seat.length;
        }
        int index = qu.poll();
        return index + 1;
    }

    public void unReserve(int seatNumber) {
        qu.add(seatNumber - 1);
    }
}
