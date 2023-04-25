package com.assignment.FC;

public class BookingFrame {
    private CustomerLogic customer;
    private SessionLogic lesson;
    private boolean attended;
    private int rating;

    public BookingFrame(CustomerLogic customer, SessionLogic lesson) {
        this.customer = customer;
        this.lesson = lesson;
        this.attended = false;
    }

    public CustomerLogic getCustomer() {
        return customer;
    }

    public SessionLogic getLesson() {
        return lesson;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public void setLesson(SessionLogic lesson) {
        this.lesson = lesson;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

}

