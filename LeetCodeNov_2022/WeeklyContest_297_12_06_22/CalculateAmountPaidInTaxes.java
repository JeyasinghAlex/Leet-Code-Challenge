package WeeklyContest_297_12_06_22;

public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double pre = 0;
        double ret = 0;
        for(int i = 0;i < brackets.length;i++){
            ret += Math.max(0, (Math.min(income, brackets[i][0]) - pre)) * brackets[i][1] / 100.;
            pre = brackets[i][0];
        }
        return ret;
    }
}
