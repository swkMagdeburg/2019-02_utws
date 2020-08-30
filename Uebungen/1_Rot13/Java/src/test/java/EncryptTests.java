import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptTests {
    private Rot13Security _sut;

    @BeforeEach
    public void SetUp() {
        _sut = new Rot13Security();
    }

    @Test
    public void EncryptShouldHandleEmptyString() {
        // Arrange
        var sut = new Rot13Security();

        // Act
        var actual = sut.Encrypt("");

        // Assert
        assertEquals("", actual);
    }

    @Test
    public void EncryptShouldThrowExceptionWhenNull() {
        assertThrows(NullPointerException.class, () -> _sut.Encrypt(null));
    }

    @ParameterizedTest
    @CsvSource({
            "A, N",
            "B, O",
            "C, P",
            "M, Z"
    })
    public void EncryptShouldShiftUpperCaseCharacter(String character, String expected) {
        assertEquals(expected, _sut.Encrypt(character));
    }

    @ParameterizedTest
    @CsvSource({
            "b, O",
            "a, N",
            "c, P",
            "m, Z"
    })
    public void EncryptShouldUpperCaseAndShiftLowerCaseCharacter(String character, String expected) {
        assertEquals(expected, _sut.Encrypt(character));
    }

    @ParameterizedTest
    @CsvSource({
            "N, A",
            "O, B",
            "Z, M"
    })
    public void EncryptShouldShiftToStartOfAlphabetWhenItsEndIsReached(String character, String expected) {
        assertEquals(_sut.Encrypt(character), expected);
    }

    @ParameterizedTest
    @CsvSource({
            "Hello, URYYB",
            "World, JBEYQ",
            "Hello World!, URYYB JBEYQ!"
    })
    public void EncryptShouldWorkWithWords(String word, String expected) {
        assertEquals(expected, _sut.Encrypt(word));
    }

    @Test
    public void EncryptShouldNotShiftSpecialCharacters() {
        var specialCharacters = "01234567890, !§$%&/()=[]{}";
        assertEquals(specialCharacters, _sut.Encrypt(specialCharacters));
    }

    @ParameterizedTest
    @CsvSource({
            "Ä, AE",
            "Ö, OE",
            "Ü, UE",
            "ä, ae",
            "ö, oe",
            "ü, ue"
    })
    public void EncryptShouldConvertUmlauts(String umlaut, String convertedUmlaut) {
        assertEquals(_sut.Encrypt(convertedUmlaut), _sut.Encrypt(umlaut));
    }
}
