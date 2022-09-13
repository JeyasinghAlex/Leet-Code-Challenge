public class UTF_8_Validation {

    public boolean validUtf8(int[] data) {

        int remaining = 0;

        for (int n : data) {

            if (remaining == 0) {
                if (n >> 7 == 0b0) {
                    remaining = 0;
                } else if (n >> 5 == 0b110) {
                    remaining = 1;
                } else if (n >> 4 == 0b1110) {
                    remaining = 2;
                } else if (n >> 3 == 0b11110) {
                    remaining = 3;
                } else {
                    return false;
                }
            } else {
                if (n >> 6 == 0b10) {
                    --remaining;
                } else {
                    return false;
                }
            }
        }
        if (remaining == 0) {
            return true;
        }
        return false;
    }
}
