package BiweeklyContest_95_07_01_23;

public class CategorizeBoxAccordingToCriteria {

    public String categorizeBox(int length, int width, int height, int mass) {

        int max = (int) 1e4;
        long vMax = (long) 1e9;

        long volume = (long)length * (long)width * (long)height;
        boolean heavy = false;
        boolean bulky = false;

        if (length >= max || width >= max || height >= max || volume >= vMax) {
            bulky = true;
        }
        if (mass >= 100) {
            heavy = true;
        }

        if (bulky && heavy) {
            return "Both";
        }
        if (!bulky && !heavy) {
            return "Neither";
        }
        if (bulky && !heavy) {
            return "Bulky";
        }
        if (!bulky && heavy) {
            return "Heavy";
        }
        return "";
    }
}
