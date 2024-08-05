package InterviewBit;

public class BinaryRepresentation {

    public String findDigitsInBinary(int A) {

        if (A == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        for ( ; A != 0; A >>>= 1) {
            sb.append(A & 1);
        }
        return sb.reverse().toString();
    }
}
