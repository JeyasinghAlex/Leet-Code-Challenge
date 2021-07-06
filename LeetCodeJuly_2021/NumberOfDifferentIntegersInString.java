import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {


    public int numDifferentIntegers(String word) {

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (char ch : word.toCharArray()) {

            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else if (sb.length() >= 1){
                set.add(removeLeadingZero(sb));
                sb = new StringBuilder();
            }
        }
        if (sb.length() >= 1)
            set.add(removeLeadingZero(sb));

        return set.size();
    }

    private String removeLeadingZero(StringBuilder sb) {

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
