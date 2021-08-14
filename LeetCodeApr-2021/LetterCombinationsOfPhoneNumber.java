import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        String[] button = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        combination(button, list, 0, digits.length(), "", digits);
        return list;
    }

    private void combination(String[] button, List<String> list, int index, int len, String str, String digits) {

        if (str.length() == len) {
            list.add(str);
            return ;
        }

        int idx = digits.charAt(index) - '0';
        for (char ch : button[idx].toCharArray()) {
            combination(button, list, index + 1, len, str + ch, digits);
        }

    }
}
