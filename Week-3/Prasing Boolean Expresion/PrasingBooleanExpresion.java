public class PrasingBooleanExpresion {
    public static void main(String[] args) {
        String expression = "&(|(f))";

        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        return evaluate(expression, 0, expression.length() - 1);
    }

    public static boolean evaluate(String s, int start, int end) {
        char ch = s.charAt(start);

        if (ch == 't') {
            return true;
        }

        if (ch == 'f') {
            return false;
        }

        if (ch == '!') {
            return !evaluate(s, start + 2, end - 1);
        }

        boolean result = (ch == '&');

        int balance = 0;
        int partStart = start + 2;

        for (int i = start + 2; i < end; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            } else if (c == ',' && balance == 0) {
                boolean value = evaluate(s, partStart, i - 1);

                if (ch == '&') {
                    result = result && value;
                } else {
                    result = result || value;
                }

                partStart = i + 1;
            }
        }

        boolean value = evaluate(s, partStart, end - 1);

        if (ch == '&') {
            result = result && value;
        } else {
            result = result || value;
        }

        return result;
    }
}