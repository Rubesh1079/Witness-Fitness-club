package com.assignment.FC;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
class LessonTest {
    @Test
    public void testConstructor() {
        String fitnessType = "Football";
        String day = "Sunday";
        String weekend = "No";
        int price = 8;

        SessionLogic lesson = new SessionLogic(fitnessType, day, weekend, price);

        assertNotNull(lesson);
        assertEquals(fitnessType, lesson.getFitnessType());
        assertEquals(day, lesson.getDay());
        assertEquals(weekend, lesson.getWeekend());
        assertEquals(price, lesson.getPrice());
    }

    @Test
    public void testIsBookingFull() {
        String fitnessType = "Football";
        String day = "Sunday";
        String weekend = "No";
        int price = 8;

        SessionLogic lesson = new SessionLogic(fitnessType, day, weekend, price);
        CustomerLogic customer = new CustomerLogic("Harry", "harry@gmail.com");

        assertFalse(lesson.isBookingFull());


        for (int i = 0; i < 10; i++) {
            lesson.addBookingList(new BookingFrame(customer, lesson));
        }
        assertTrue(lesson.isBookingFull());
    }

    @Test
    public void testAddBookingList() {
        String fitnessType = "Football";
        String day = "Sunday";
        String weekend = "No";
        int price = 8;

        SessionLogic lesson = new SessionLogic(fitnessType, day, weekend, price);
        CustomerLogic customer = new CustomerLogic("Harry", "harry@gmail.com");
        ArrayList<BookingFrame> bookingList = lesson.getBookingList();
        assertNotNull(bookingList);
        assertEquals(0, bookingList.size());

        lesson.addBookingList(new BookingFrame(customer, lesson));
        assertEquals(1, bookingList.size());
    }

    @Test
    public void testRemoveBookingList() {
        String fitnessType = "Football";
        String day = "Sunday";
        String weekend = "No";
        int price = 8;

        SessionLogic lesson = new SessionLogic(fitnessType, day, weekend, price);
        CustomerLogic customer = new CustomerLogic("Harry", "harry@gmail.com");

        ArrayList<BookingFrame> bookingList = lesson.getBookingList();
        assertNotNull(bookingList);
        assertEquals(0, bookingList.size());

        BookingFrame booking = new BookingFrame(customer, lesson);
        lesson.addBookingList(booking);
        assertEquals(1, bookingList.size());

        lesson.removeBookingList(booking);
        assertEquals(0, bookingList.size());
    }
}