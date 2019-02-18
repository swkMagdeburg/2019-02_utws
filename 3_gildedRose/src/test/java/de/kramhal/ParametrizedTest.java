package de.kramhal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
 */
class ParametrizedTest
{

    static Stream<Arguments> provideParseValues() {
        return Stream.of(
                Arguments.of("5", 5),
                Arguments.of("-5", -5),
                Arguments.of("0", 1)
        );
    }

    @DisplayName("tests parsing of Integers")
    @ParameterizedTest(name = "Test #{index}: \"{0}\" should be {1}")
    @MethodSource("provideParseValues")
    void testValue(String in, int expected){
        assertEquals(expected, Integer.parseInt(in));
    }
}
