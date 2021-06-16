public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {

        int st = 0;
        int ed = arr.length - 1;

        while(st < ed) {
            if (arr[st + 1] > arr[st]) {
                st++;
            } else if (arr[ed - 1] > arr[ed]) {
                ed--;
            } else {
                break;
            }
        }

        return st != 0 && ed != arr.length - 1 && st == ed;
    }
}
