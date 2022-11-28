import java.util.Arrays;
import java.util.TreeMap;

public class MaximumEarningsFromTaxi {

    public long maxTaxiEarnings(int n, int[][] rides) {

        int len = rides.length;
        Ride[] ridesArr = new Ride[len];

        for (int i = 0; i < len; ++i) {
            int[] ride = rides[i];
            ridesArr[i] = new Ride(ride[0], ride[1], ride[2]);
        }
        Arrays.sort(ridesArr, (a, b) -> a.end - b.end);
        TreeMap<Integer, Long> tMap = new TreeMap<>();
        tMap.put(0, 0L);

        for (Ride ride : ridesArr) {
            long val = tMap.floorEntry(ride.start).getValue() + ride.end - ride.start + ride.tip;
            long maxValue = tMap.lastEntry().getValue();

            if (val > maxValue) {
                tMap.put(ride.end, val);
            }
        }
        return tMap.lastEntry().getValue();
    }
}

class Ride {

    int start;
    int end;
    int tip;

    public Ride(int start, int end, int tip) {
        this.start = start;
        this.end = end;
        this.tip = tip;
    }
}
