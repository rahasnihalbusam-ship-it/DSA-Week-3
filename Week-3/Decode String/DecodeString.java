import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        String s = "3[a2[c]]";

        String result = decodeString(s);

        System.out.println(result);
    }

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(count);
                stringStack.push(current);

                count = 0;
                current = new StringBuilder();
            }
            else if (ch == ']') {
                int repeat = countStack.pop();

                StringBuilder previous = stringStack.pop();

                for (int j = 0; j < repeat; j++) {
                    previous.append(current);
                }

                current = previous;
            }
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}