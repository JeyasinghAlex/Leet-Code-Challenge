public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {

        if (area == 0) {
            return new int[]{0, 0};
        }
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
