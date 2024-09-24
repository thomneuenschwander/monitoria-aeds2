package tp01.ex14;

import java.util.Scanner;

/**
 * Algebra Booleana
 * 
 * GitHub: https://github.com/Gaok1
 * 
 * @author Luis Phillip Lemos Martins
 * @since 01/09/2024
 */
public class AlgebraBooleanaRecursiva {

    static String replaceVariables(String expression) {
        expression = expression.replaceAll(" ", "");
        int numVariables = Integer.parseInt(expression.substring(0, 1));

        int[] variableValues = new int[numVariables];
        for (int i = 0; i < numVariables; i++)
            variableValues[i] = Integer.parseInt(expression.substring(i + 1, i + 2));

        expression = expression.substring(numVariables + 1);
        if (numVariables > 0) expression = expression.replace("A", String.valueOf(variableValues[0]));
        if (numVariables > 1) expression = expression.replace("B", String.valueOf(variableValues[1]));
        if (numVariables > 2) expression = expression.replace("C", String.valueOf(variableValues[2]));

        expression = expression.replace("and", "V");
        expression = expression.replace("or", "^");
        expression = expression.replace("not", "!");
        return expression;
    }

    static int findOperator(String expression, int index) {
        for (int i = index + 1; i < expression.length(); i++) {
            if (expression.charAt(i) == 'V'
                    || expression.charAt(i) == '^'
                    || expression.charAt(i) == '!')
                return i;
            if (expression.charAt(i) == ')')
                return -1;
        }
        return -1;
    }

    static int findEndOfExpression(String str, int index) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ')')
                return i;
        return -1;
    }

    static String resolveAnd(String expression, int index) {
        int endIndex = findEndOfExpression(expression, index);
        String result = expression.substring(0, index);
        boolean expressionIsFalse = false;
        String innerExpression = expression.substring(index + 2, endIndex);
        String[] operands = innerExpression.split(",");

        for (String operand : operands) {
            if (operand.equals("0")) {
                result += "0";
                expressionIsFalse = true;
                break;
            }
        }

        if (!expressionIsFalse)
            result += "1";

        result += expression.substring(endIndex + 1);
        return result;
    }

    static String resolveOr(String expression, int index) {
        int endIndex = findEndOfExpression(expression, index);
        String result = expression.substring(0, index);
        boolean expressionIsTrue = false;
        String innerExpression = expression.substring(index + 2, endIndex);
        String[] operands = innerExpression.split(",");

        for (String operand : operands) {
            if (operand.equals("1")) {
                result += "1";
                expressionIsTrue = true;
                break;
            }
        }

        if (!expressionIsTrue)
            result += "0";

        result += expression.substring(endIndex + 1);
        return result;
    }

    static String resolveNot(String expression, int index) {
        int endIndex = findEndOfExpression(expression, index);
        String result = expression.substring(0, index);
        String innerExpression = expression.substring(index + 2, endIndex);

        result += innerExpression.equals("1") ? "0" : "1";
        result += expression.substring(endIndex + 1);
        return result;
    }

    static String resolve(String expression, int index) {
        int nextOperatorIndex = findOperator(expression, index);
        while (nextOperatorIndex != -1) {
            expression = resolve(expression, nextOperatorIndex);
            nextOperatorIndex = findOperator(expression, index);
        }

        if (expression.charAt(index) == 'V')
            expression = resolveAnd(expression, index);
        else if (expression.charAt(index) == '^')
            expression = resolveOr(expression, index);
        else if (expression.charAt(index) == '!')
            expression = resolveNot(expression, index);

        return expression;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (!line.equals("0")) {
            line = replaceVariables(line);
            System.out.println(resolve(line, 0));
            line = sc.nextLine();
        }

        sc.close();
    }
}
