package com.assignment.FC;

import java.util.ArrayList;

public class SystemLogic {
    private String fitnessType;
    private String day;
    private String weekend;
    private int maxCapacity = 5;

    private int Capacity;
    private int price;

    private ArrayList<BookingFrame> bookingList;

    public SessionLogic(String fitnessType, String day, String weekend, int price) {
        this.fitnessType = fitnessType;
        this.day = day;
        this.weekend = weekend;
        this.price = price;
        this.Capacity = price;
        this.bookingList = new ArrayList<>();
    }

    public String getFitnessType() {
        return fitnessType;
    }

    public String getDay() {
        return day;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getWeekend(){
        return weekend;
    }

    public ArrayList<BookingFrame> getBookingList() {
        return bookingList;
    }

    public void getTheThingsForReport(){
        String customerNumber;
        if (bookingList.contains(getFitnessType()) && bookingList.equals("Yoga")){

        }

    }

    public boolean isBookingFull() {
        return bookingList.size() >= price;
    }

    public void addBookingList(BookingFrame booking){
        bookingList.add(booking);
        Capacity--;
    }

    public void removeBookingList(BookingFrame booking){
        bookingList.remove(booking);
        Capacity++;

    }




    public void viewLessonByDay(String selectedDay){

        if (selectedDay.equalsIgnoreCase(getDay())){
            System.out.printf("%-10s %-10s %-10s %-10d $%-10d \n", day, fitnessType, weekend, Capacity, price);
        }
    }

    public void viewLessonByFitnessType(String selectedFitnessType){
        if (selectedFitnessType.equalsIgnoreCase(getFitnessType())){
            System.out.printf("%-10s %-10s %-10s %-10d $%-10d \n", fitnessType, day, weekend, Capacity, price);
        }
    }


}
