package TONGCHENG581014;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/14 19:22
 */

public class Main2 {
    public static void main(String[] args) {
        String exprStr = "exp1 & (exp2 | exp3) | !exp4";
        String s = convertInfix2Postfix(exprStr);
        System.out.println(s);
    }

    public static String convertInfix2Postfix (String exprStr) {
        // write code here
        Stack<String> opStack = new Stack<>();
        List<String> expressList = new ArrayList<>();
        String curStr = "";
        exprStr = exprStr.replace(" ", "");
        for (int i = 0; i < exprStr.length(); i++) {
            char charAt = exprStr.charAt(i);
            if (charAt == '(' || charAt == ')' || charAt == '!' || charAt == '&' || charAt == '|') {
                if (curStr != "") {
                    expressList.add(curStr);
                }
                expressList.add(String.valueOf(charAt));
                curStr = "";
            } else {
                curStr += charAt;
            }
        }
        if (curStr != "") {
            expressList.add(curStr);
        }
        List<String> suffixList = new ArrayList<>();
        for (String item : expressList) {
            if (item.equals("!") || item.equals("&") || item.equals("|")) {
                if (opStack.isEmpty() || priority(item) >= priority(opStack.peek())) {
                    opStack.push(item);
                } else {
                    // 出栈
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())) {
                        if (priority(item) <= priority(opStack.peek())) {
                            suffixList.add(opStack.pop());
                        }
                    }
                    opStack.push(item);
                }
            } else if ("(".equals(item)) {
                opStack.push(item);
            } else if (")".equals(item)) {
                while (!opStack.isEmpty()) {
                    if ("(".equals(opStack.peek())) {
                        opStack.pop();
                        break;
                    } else {
                    }
                }
            } else {
                if (!item.equals("(") && !item.equals(")")) {
                    suffixList.add(item);
                }
            }
        }
        while (!opStack.isEmpty()) {
            suffixList.add(opStack.pop());
        }
        String res = "";
        for (int i = 0; i < suffixList.size(); i++) {
            res += suffixList.get(i) + " ";
        }
        return res.trim();
    }

    public static int priority(String op) {
        if (op.equals("(") || op.equals(")")) {
            return 4;
        } else if (op.equals("!")) {
            return 3;
        } else if (op.equals("&")) {
            return 2;
        } else if (op.equals("|")) {
            return 1;
        }
        return -1;
    }
}
