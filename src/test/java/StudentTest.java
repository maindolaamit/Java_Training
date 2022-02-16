import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void testStudentConstructor() {
        Student student = new Student("John", "Doe", "test@email.com", 1);
        assertEquals("John", student.getName());
    }
}