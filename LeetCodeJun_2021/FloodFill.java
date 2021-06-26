public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        if (old == newColor){
            return image;
        }

        floodFill(image, sr, sc, newColor, old);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int c, int old) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != old) {
            return;
        }

        if (image[sr][sc] == old) {
            image[sr][sc] = c;
        }

        floodFill(image, sr, sc + 1, c, old);
        floodFill(image, sr, sc - 1, c, old);
        floodFill(image, sr + 1, sc, c, old);
        floodFill(image, sr - 1, sc, c, old);
    }
}
