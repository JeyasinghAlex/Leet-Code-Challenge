public class SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {

        int[] parent = new int[26];

        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        for (String equation : equations) {

            char equality = equation.charAt(1);

            if (equality == '=') {

                int a = find(equation.charAt(0) - 'a', parent);
                int b = find(equation.charAt(3) - 'a', parent);

                if (a != b) {
                    parent[b] = a;
                }
            }
        }

        for (String equation : equations) {

            char equality = equation.charAt(1);

            if (equality == '!') {
                int a = find(equation.charAt(0) - 'a', parent);
                int b = find(equation.charAt(3) - 'a', parent);

                if (a == b) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int index, int[] parent) {
        if (parent[index] == index) {
            return index;
        }
        return find(parent[index], parent);
    }
}
