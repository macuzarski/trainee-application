import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BalancedWordsCounter {

    private HashMap<String, Integer> memoMap = new HashMap<>();

    public Integer count(String input) {

        if (input == null) {
            throw new RuntimeException();
        }
        if (input.length() == 0) return 0;

        if (!input.matches("[a-zA-Z]+")) {
            throw new RuntimeException();
        }

        if (input.length() == 1) return 1;

        if (this.memoMap.containsKey(input)) {
            return this.memoMap.get(input);
        }

        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            String subWord = input.substring(0, i + 1);
            if (isBalanced(subWord)) {
                counter++;
            } else {
                this.memoMap.put(subWord, 0);
            }
        }

        int result = counter + count(input.substring(1));
        this.memoMap.put(input, result);
        return result;
    }

    private boolean isBalanced(String s) {
        Map<Character, Integer> charAppearances = new HashMap<>();
        for (char letter : s.toCharArray()) {
            charAppearances.put(letter, charAppearances.getOrDefault(letter, 0) + 1);
        }
        return new HashSet<>(charAppearances.values()).size() == 1;
    }
}
