package com.assignment.FC;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class SessionLogicTest {

    @org.junit.jupiter.api.Test
    void isBookingFull() {
        SessionLogic sessionLogic = new SessionLogic("Yoga", "Monday", "Weekend", 5);
        assertFalse(sessionLogic.isBookingFull());
        CustomerLogic customer1 = new CustomerLogic("Harry", "harry@gmail.com");

        BookingFrame booking = new BookingFrame(new CustomerLogic("Harry", "harry@gmail.com"), new SessionLogic("Football", "Saturday", "Weekend 1", 4));
        sessionLogic.addBookingList(booking);
        assertFalse(sessionLogic.isBookingFull());

        sessionLogic.addBookingList(booking);
        sessionLogic.addBookingList(booking);
        sessionLogic.addBookingList(booking);
        sessionLogic.addBookingList(booking);
        sessionLogic.addBookingList(booking);
        assertTrue(sessionLogic.isBookingFull());
    }

    @org.junit.jupiter.api.Test
    void addBookingList() {
        SessionLogic sessionLogic = new SessionLogic("Yoga", "Monday", "Weekend", 5);
        BookingFrame booking = new BookingFrame(new CustomerLogic("Harry", "harry@gmail.com"), new SessionLogic("Football", "Saturday", "Weekend 1", 4));
        sessionLogic.addBookingList(booking);
        assertEquals(4, sessionLogic.getCapacity());
        assertEquals(1, sessionLogic.getBookingList().size());
    }

    @org.junit.jupiter.api.Test
    void removeBookingList() {
        SessionLogic sessionLogic = new SessionLogic("Yoga", "Monday", "Weekend", 5);
        BookingFrame booking = new BookingFrame(new CustomerLogic("Harry", "harry@gmail.com"), new SessionLogic("Football", "Saturday", "Weekend 1", 4));
        sessionLogic.addBookingList(booking);
        sessionLogic.removeBookingList(booking);
        assertEquals(5, sessionLogic.getCapacity());
        assertEquals(0, sessionLogic.getBookingList().size());
    }
}