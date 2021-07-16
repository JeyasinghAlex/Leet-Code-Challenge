public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray())  {
            if (ch == '.') {
                sb.append('[');
                sb.append(ch);
                sb.append(']');
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
