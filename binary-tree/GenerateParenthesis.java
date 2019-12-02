import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        helper(output, "", 0, 0, n);
        return output;
    }

    private void helper(List<String> output, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            output.add(cur);
            return;
        }

        if (left < n) {
            helper(output, cur + LEFT, left + 1, right, n);
        }

        if (right < left) {
            helper(output, cur + RIGHT, left, right + 1, n);
        }
    }
}