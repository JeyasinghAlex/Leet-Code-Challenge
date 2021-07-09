public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {

        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        double sum = 0;
        for (int n : salary) {

            if (n < min)
                min = n;

            if (n > max)
                max = n;

            sum += n;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
