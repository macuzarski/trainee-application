import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest {
    BalancedWordsCounter bwc = new BalancedWordsCounter();
    String input;


    @Test
    public void shouldCountBalancedWordsWithinInput() {
        //Given
        input = "aabbabcccba";
        //When
        int result = bwc.count(input);
        //Then
        Assertions.assertEquals(result, 28);
    }

    @Test
    public void emptyInputShouldResultInZeroBalancedWords() {
        //Given
        input = "";
        //When
        int result = bwc.count(input);
        //Then
        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenInputWithAnythingButLettersShouldThrowRuntimeException() {
        //Given
        input = "aabba1bcccba";
        //Then
        Exception exc = assertThrows(RuntimeException.class, () -> {
            bwc.count(input);
        });
    }

    @Test
    public void givenNullShouldThrowRuntimeException() {
        //Given
        input = null;
        //Then
        Exception exc = assertThrows(RuntimeException.class, () -> {
            bwc.count(input);
        });
    }

}