package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ValidParantheses : ValidParantheses
 *
 */
public class ValidParantheses {
    public static void main (String[] args) {
        ValidParantheses vp = new ValidParantheses();
        String parantheses = "(]";//"(){}[]";
        System.out.println("Is valid parantheses? " + vp.isValidParantheses(parantheses));
    }

    private boolean isValidParantheses(String parantheses) {
        boolean isValid = false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<parantheses.length(); i++) {
            if (!stack.isEmpty() && map.get(stack.peek()) != null && map.get(stack.peek()) == parantheses.charAt(i)) {
                stack.pop();
            } else {
                stack.push(parantheses.charAt(i));
            }
        }

        return isValid = stack.isEmpty();
    }
}
