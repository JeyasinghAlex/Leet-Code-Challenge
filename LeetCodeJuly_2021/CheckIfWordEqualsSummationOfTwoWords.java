public class CheckIfWordEqualsSummationOfTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        return getIntValue(targetWord) == getIntValue(firstWord) + getIntValue(secondWord);
    }

    private int getIntValue(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum = (sum * 10) + ch - 'a';
        }
        return sum;
    }
}
