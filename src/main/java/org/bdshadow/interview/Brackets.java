package org.bdshadow.interview;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {


    public boolean isCorrect(String s) {
        HashMap<String, String> finiteState = new HashMap<>();
        finiteState.put("(", ")");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if (!stack.contains(character)) {
                String next = finiteState.get(character);
                if (next != null) {
                    switch (next) {
                        case "TERMINATOR": continue;
                        default:
                            stack.push(next);
                            continue;
                    }
                }
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
