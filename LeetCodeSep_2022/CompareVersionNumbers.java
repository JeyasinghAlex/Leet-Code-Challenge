public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        int j = 0;
        while (i < v1.length || j < v2.length) {

            int a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int b = j < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
            ++i;
            ++j;
        }
        return 0;
    }
}
