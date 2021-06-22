public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {

        int pow = 1;
        int sum = 0;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            int num = columnTitle.charAt(i) - 64;
            sum += pow * num;
            pow = pow * 26;
        }
        return sum;
    }
}
