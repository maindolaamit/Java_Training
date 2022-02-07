import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class MyFirstProgramTest {

    @Test
    public void isSubstring() {
        assertTrue(MyFirstProgram.isSubstring("Hello", "o"));
        assertTrue(MyFirstProgram.isSubstring("Hello", "llo"));
        assertTrue(MyFirstProgram.isSubstring("Hello", "Hello"));
        assertFalse(MyFirstProgram.isSubstring("Hello", "Hi"));
        assertFalse(MyFirstProgram.isSubstring("Hello", ""));
        assertFalse(MyFirstProgram.isSubstring("", ""));
    }
}