import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BubbleSortTest {
    BubbleSort bubbleSort = new BubbleSort();
    List<Comparable> input;

    @Test
    public void shouldSortNaturalNumbersWithDuplicates() {
        //Given
        input = Arrays.asList(1,4,5,6,8,3,8);
        //When
        List<Comparable> result = bubbleSort.sort(input);
        //Then
        Assertions.assertEquals(Arrays.asList(1,3,4,5,6,8,8), result);
    }

    @Test
    public void shouldSortFloatingPointNumbers() {
        //Given
        input = Arrays.asList(-9.3,0.2,4,0.1,5,9);
        //When
        List<Comparable> result = bubbleSort.sort(input);
        //Then
        Assertions.assertEquals(Arrays.asList(-9.3,0.1,0.2,4,5,9), result);
    }

    @Test
    public void givenEmptyShouldReturnEmpty() {
        //Given
        input = List.of();
        //When
        List<Comparable> result = bubbleSort.sort(input);
        //Then
        Assertions.assertEquals(List.of(), result);
    }

    @Test
    public void shouldPopNullValuesFromCollection() {
        //Given
        input = Arrays.asList(null, 5.0001);
        //When
        List<Comparable> result = bubbleSort.sort(input);
        //Then
        Assertions.assertEquals(Arrays.asList(5.0001), result);
    }

    @Test
    public void givenNullShouldThrowRuntimeException() {
        //Given
        input = null;
        //Then
        Exception exc = assertThrows(RuntimeException.class, () -> {
            bubbleSort.sort(input);
        });

    }

}