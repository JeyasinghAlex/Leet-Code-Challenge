import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String removeDots = local[0].replace(".", "");
            set.add(removeDots + "@" + parts[1]);
        }
        return set.size();
    }

    public int numUniqueEmails_1(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            boolean next = false;
            for (char ch : email.toCharArray()) {

                if (ch == '+') {
                    flag = false;
                }
                if (ch == '@') {
                    next = true;
                    flag = false;
                }
                if (ch != '.' && flag) {
                    sb.append(ch);
                }
                if (next) {
                    sb.append(ch);
                }
            }
            set.add(sb.toString());
        }
        System.out.println(set);

        return set.size();
    }
}
