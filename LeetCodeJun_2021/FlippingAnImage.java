import java.util.Arrays;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] arr : image) {
            int[] temp = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = temp[temp.length - 1 - i] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
