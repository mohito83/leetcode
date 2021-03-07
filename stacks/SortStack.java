package stacks;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();

        while (!s1.isEmpty()) {
            if (s2.isEmpty()) {
                s2.push(s1.pop());
            } else if (s1.peek() < s2.peek()) {
                int temp = s1.pop();
                while (!s2.isEmpty() && temp < s2.peek()) {
                    s1.push(s2.pop());
                }
                s2.push(temp);
            } else {
                s2.push(s1.pop());
            }
        }

        //Stack is backwards
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return s1;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(4);
        s1.push(7);
        s1.push(6);
        s1.push(1);

        SortStack ss = new SortStack();
        Stack<Integer> sortedStack = ss.sortStack(s1);
        System.out.println("Sorted stack as follows: ");
        ss.printStack(sortedStack);
    }

    private void printStack(Stack<Integer> sortedStack) {
        if (sortedStack.isEmpty()) {
            return;
        }
        int val = sortedStack.pop();
        printStack(sortedStack);
        System.out.println(val);
        sortedStack.push(val);
    }
}
