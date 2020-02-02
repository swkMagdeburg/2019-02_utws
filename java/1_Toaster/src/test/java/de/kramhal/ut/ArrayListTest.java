package de.kramhal.ut;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArrayListTest
{
    @Test
    void testArrayListContains()
    {
        final List<String> sut = new ArrayList<>(
                Arrays.asList("Auto", "Brot", "Fuß"));
        assertTrue(sut.contains("Brot"));
    }

    @Test
    void testArrayListDoesNotContain()
    {
        final List<String> sut = new ArrayList<>(
                Arrays.asList("Auto", "Brot", "Fuß"));
        assertFalse(sut.contains("Blumen"));
    }
}
