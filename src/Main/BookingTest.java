package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking testing = new Booking("hert69104","zumba","02-01-2022","booked","Good",4,10);
    @Test
    void getBookingId() {
        String expected = "hert69104";
        String result = testing.getBookingId();
        assertEquals(expected,result);
    }

    @Test
    void getLessonName() {
        String expected = "zumba";
        String result = testing.getLessonName();
        assertEquals(expected,result);
    }

    @Test
    void getLessonDate() {
        String expected = "02-01-2022";
        String result = testing.getLessonDate();
        assertEquals(expected,result);
    }
    @Test
    void getBookingStatus() {
        String expected = "booked";
        String result = testing.getBookingStatus();
        assertEquals(expected,result);
    }

    @Test
    void getRating() {
        int expected = 4;
        int result = testing.getRating();
        assertEquals(expected,result);
    }

}