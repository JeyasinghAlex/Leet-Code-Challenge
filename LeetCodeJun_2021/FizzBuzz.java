import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String fizz = "Fizz";
        String fizzBuzz = "FizzBuzz";
        String buzz = "Buzz";
        for (int i = 1; i <= n; ++i) {

            if (i % 3 == 0 && i % 5 == 0) {
                list.add(fizzBuzz);
            } else if (i % 3 == 0) {
                list.add(fizz);
            } else if (i % 5 == 0) {
                list.add(buzz);
            }else {
                list.add(i + "");
            }
        }
        return list;
    }
}
