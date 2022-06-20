import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BubbleSort {

    public List<Comparable> sort(List<Comparable> input) {
        if (input == null) {
            throw new RuntimeException();
        }

        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        List<Comparable> sorted = input.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (sorted.size() == 1) {
            return sorted;
        }

        for (int i = 0; i < sorted.size(); i++) {
            for (int j = 0; j < sorted.size() - 1; j++) {
                var comparingResult = compareNumbersByValue(sorted.get(j), sorted.get(j + 1));

                if (comparingResult == null) {
                    comparingResult = sorted.get(j).compareTo(sorted.get(j + 1));
                }

                if (comparingResult > 0) {
                    Collections.swap(sorted, j, j + 1);
                }
            }
        }
        return sorted;
    }

    private Integer compareNumbersByValue(Comparable number1, Comparable number2) {
        if (number1 instanceof Number && number2 instanceof Number) {
            return Double.compare(((Number) number1).doubleValue(), ((Number) number2).doubleValue());
        }

        return null;
    }
}
