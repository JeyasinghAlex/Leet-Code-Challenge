package InterviewBit;

public class ExcelColumnTitle {

    public String convertToTitle(int A) {

        StringBuilder sb = new StringBuilder();
        while (A != 0) {
            int val = (A - 1) % 26;
            sb.append((char) (val + 'A'));
            A = (A - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
