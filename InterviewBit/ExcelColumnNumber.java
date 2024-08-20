package InterviewBit;

public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        int n = A.length();
        int sum = 0;
        int pow = 1;
        for (int i = n - 1; i >= 0; --i) {
            int num = A.charAt(i) - 64;
            sum += (pow * num);
            pow = pow * 26;
        }
        return sum;
    }
}
