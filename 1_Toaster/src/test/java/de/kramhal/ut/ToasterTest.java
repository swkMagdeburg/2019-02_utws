package de.kramhal.ut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToasterTest {

    @Test
    void toast() {
        assertNotNull(new Toaster());
    }
}