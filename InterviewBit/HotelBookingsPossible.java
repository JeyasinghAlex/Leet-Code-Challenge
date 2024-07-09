package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        int n = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);

        int i = 0;
        int j = 0;
        int max = 1;
        int room = 0;
        while (i < n && j < n) {
            if (arrive.get(i) <= depart.get(j)) {
                ++room;
                ++i;
            }
            else {
                --room;
                ++j;
            }
            max = Math.max(max, room);
        }
        return max <= K;
    }

    public boolean hotel_1(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        int n = arrive.size();
        List<int[]> list = new ArrayList<>();
        Collections.sort(arrive);
        Collections.sort(depart);

        int max = 1;
        int room = 0;
        int j = 0;
        int limit = depart.get(0);
        for (int i = 0; i < n; ++i) {

            if (arrive.get(i) > limit) {
                limit = depart.get(++j);
            }
            else {
                ++room;
            }
            max = Math.max(max, room);
        }

        return max <= K;
    }
}
