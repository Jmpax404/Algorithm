import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/": {
                    cal(stack, s);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(s));
                    break;
                }
            }
        }
        return stack.pop();
    }

    private void cal(Deque<Integer> stack, String symbol) {
        Integer val2 = stack.pop();
        Integer val1 = stack.pop();
        switch (symbol) {
            case "+": {
                val1 += val2;
                break;
            }
            case "-": {
                val1 -= val2;
                break;
            }
            case "*": {
                val1 *= val2;
                break;
            }
            case "/": {
                val1 /= val2;
                break;
            }
        }
        stack.push(val1);
    }
}