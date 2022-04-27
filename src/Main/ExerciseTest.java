package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {
    Exercise testing = new Exercise("swimming","Afternoon","01-01-2022",4,2);

    @Test
    void getLessonName() {
            String expected = "swimming";
            String result = testing.getLessonName();
            assertEquals(expected,result);
    }

    @Test
    void getCapacity() {
        int expected = 4;
        int result = testing.getCapacity();
        assertEquals(expected,result);
    }

    @Test
    void getSession() {
        String expected = "Afternoon";
        String result = testing.getSession();
        assertEquals(expected,result);
    }

    @Test
    void getDate() {
        String expected = "01-01-2022";
        String result = testing.getDate();
        assertEquals(expected,result);
    }

    @Test
    void getPrice() {
        int expected = 2;
        int result = testing.getPrice();
        assertEquals(expected,result);
    }
}