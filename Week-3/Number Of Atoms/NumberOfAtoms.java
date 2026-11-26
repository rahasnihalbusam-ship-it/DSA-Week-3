
import java.util.*;

public class NumberOfAtoms {
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";

        System.out.println(countOfAtoms(formula));
    }

    static int index = 0;

    public static String countOfAtoms(String formula) {
        index = 0;

        TreeMap<String, Integer> map = calculate(formula);

        StringBuilder result = new StringBuilder();

        for (String atom : map.keySet()) {
            result.append(atom);

            if (map.get(atom) > 1) {
                result.append(map.get(atom));
            }
        }

        return result.toString();
    }

    public static TreeMap<String, Integer> calculate(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();

        while (index < formula.length() && formula.charAt(index) != ')') {
            char ch = formula.charAt(index);

            if (ch == '(') {
                index++;

                TreeMap<String, Integer> inside = calculate(formula);

                index++;

                int multiplier = getNumber(formula);

                for (String atom : inside.keySet()) {
                    map.put(atom, map.getOrDefault(atom, 0)
                            + inside.get(atom) * multiplier);
                }
            } else {
                StringBuilder atom = new StringBuilder();

                atom.append(formula.charAt(index));
                index++;

                while (index < formula.length() &&
                       Character.isLowerCase(formula.charAt(index))) {
                    atom.append(formula.charAt(index));
                    index++;
                }

                int count = getNumber(formula);

                String name = atom.toString();

                map.put(name, map.getOrDefault(name, 0) + count);
            }
        }

        return map;
    }

    public static int getNumber(String formula) {
        int num = 0;

        while (index < formula.length() &&
               Character.isDigit(formula.charAt(index))) {
            num = num * 10 + (formula.charAt(index) - '0');
            index++;
        }

        return num == 0 ? 1 : num;
    }
}