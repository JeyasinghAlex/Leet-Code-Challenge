package LeetCode_2024;

public class MergeTripletsToFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean xFound = false;
        boolean yFound = false;
        boolean zFound = false;

        for (int[] triplet : triplets) {

            if (triplet[0] == target[0] && triplet[1] == target[1] && triplet[2] == target[2]) {
                return true;
            }

            if (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                xFound = true;
            }
            if (triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2]) {
                yFound = true;
            }
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2]) {
                zFound = true;
            }
        }
        return xFound && yFound && zFound;
    }
}
