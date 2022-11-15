package WeeklyContest_319_13_11_22;

public class ConvertTheTemperature {

    public double[] convertTemperature(double celsius) {

        double kelvin = (celsius + 273.15) % 10000;
        double fahrenheit = (celsius * 1.80 + 32.00) % 10000;
        return new double[]{kelvin, fahrenheit};
    }
}
