package com.assignment.FC;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemLogic {

    private ArrayList<SessionLogic> sessionDbArray;
    private ArrayList<CustomerLogic> customersDbArray;
    private ArrayList<BookingFrame> bookingssDbArray;

    public SystemLogic() {
        sessionDbArray = new ArrayList<>();
        customersDbArray = new ArrayList<>();
        bookingssDbArray = new ArrayList<>();
    }

    public ArrayList<BookingFrame> getBookings() {
        return bookingssDbArray;
    }

    public int getBookingIndex(String customerName, String lessonName, String lessonDay, String lessonWeekend) {
        for (int i = 0; i < bookingssDbArray.size(); i++) {
            BookingFrame booking = bookingssDbArray.get(i);
            if (booking.getCustomer().getName().equalsIgnoreCase(customerName) && booking.getLesson().getFitnessType().equalsIgnoreCase(lessonName)
                    && booking.getLesson().getDay().equalsIgnoreCase(lessonDay) && booking.getLesson().getWeekend().equalsIgnoreCase(lessonWeekend)) {
                return i;
            }
        }
        return -1; // return -1 if the booking is not found
    }

    public void viewBookingDb() {
        if (bookingssDbArray.size() != 0) {
            for (int i = 0; i < bookingssDbArray.size(); i++) {
                System.out.println("Name: " + bookingssDbArray.get(i).getCustomer().getName());
                System.out.println("Email: " + bookingssDbArray.get(i).getCustomer().getEmail());

                System.out.println("Lesson: " + bookingssDbArray.get(i).getLesson().getFitnessType());
                System.out.println("Day: " + bookingssDbArray.get(i).getLesson().getDay());
                System.out.println("Weekend: " + bookingssDbArray.get(i).getLesson().getWeekend());
                System.out.println("availableCapacity: " + bookingssDbArray.get(i).getLesson().getCapacity());
                System.out.println("rating: " + bookingssDbArray.get(i).getRating());
            }
        } else System.out.println("Nothing in array");

    }

    public void bookLesson(CustomerLogic customer, SessionLogic lesson) {
        if (lesson.isBookingFull()) {
            System.out.println("Sorry. This " + lesson.getFitnessType() + " is full");
        } else {
            BookingFrame booking = new BookingFrame(customer, lesson);
            if (lesson.getCapacity() == 0) {
                System.out.println("Sorry! No room available for this lesson");
            } else if (lesson.getCapacity() > 0) {
                lesson.addBookingList(booking);
                bookingssDbArray.add(booking);
                sessionDbArray.add(lesson);
                System.out.println("Booking confirmed for " + customer.getName() + " on " + lesson.getDay() + " for " + lesson.getFitnessType() + ".");

            }

        }

    }


    public void cancelBooking(BookingFrame booking) {
        if (booking.isAttended()) {
            System.out.println("Sorry, you cannot cancel an already attended lesson.");
        } else {
            SessionLogic lesson = booking.getLesson();
            lesson.removeBookingList(booking);
            bookingssDbArray.remove(booking);
            System.out.println("Booking cancelled for " + booking.getCustomer().getName() + " on " + lesson.getDay() + " for " + lesson.getFitnessType() + ".");

        }
    }

    public void changeBooking(BookingFrame booking, SessionLogic newlesson) {
        if (newlesson.isBookingFull()) {
            System.out.println("Sorry, this lesson is already full.");
        } else if (booking.isAttended()) {
            System.out.println("Sorry, you cannot change an already attended lesson.");
        } else {
            SessionLogic oldLesson = booking.getLesson();
            oldLesson.removeBookingList(booking);
            booking.setLesson(newlesson);
            newlesson.addBookingList(booking);
            System.out.println("Booking changed for " + booking.getCustomer().getName() + " from " + oldLesson.getDay() + " for " + oldLesson.getFitnessType() + " to " + newlesson.getDay() + " for " + newlesson.getFitnessType() + ".");
        }
    }


    public void rateLesson(BookingFrame booking, int rating) {

        if (!booking.isAttended()) {
            System.out.println("You cannot rate a lesson that you have not attended.");
        } else {
            booking.setRating(rating);
            System.out.println("Thank you for your response on the lesson " + booking.getLesson().getFitnessType());
        }
    }

    public void printMonthlyLessonReport(int monthNumber) {
        int totalCustomersFootball = 0, totalCustomersTennis = 0, totalCustomersCycling = 0, totalCustomersBoxFit = 0, totalCustomersSwimming = 0;

        double totalRatingFootball = 0, totalRatingTennis = 0, totalRatingCycling = 0, totalRatingBoxFit = 0, totalRatingSwimming = 0;
        double numOfLessonsFootball = 0, numOfLessonsTennis = 0, numOfLessonsCycling = 0, numOfLessonsBoxFit = 0, numOfLessonsSwimming = 0;
        System.out.println("Monthly Lesson Report for Month " + monthNumber);
        System.out.println("-------------------------------------");
        for (int i = 0; i < bookingssDbArray.size(); i++) {
            BookingFrame booking = bookingssDbArray.get(i);
            if (booking.getLesson().getFitnessType().equalsIgnoreCase("Football")) {
                totalCustomersFootball++;
                totalRatingFootball += booking.getRating();
                numOfLessonsFootball++;
            } else if (booking.getLesson().getFitnessType().equalsIgnoreCase("Tennis")) {
                totalCustomersTennis++;
                totalRatingTennis += booking.getRating();
                numOfLessonsTennis++;
            } else if (booking.getLesson().getFitnessType().equalsIgnoreCase("Cycling")) {
                totalCustomersCycling++;
                totalRatingCycling += booking.getRating();
                numOfLessonsCycling++;
            } else if (booking.getLesson().getFitnessType().equalsIgnoreCase("BoxFit")) {
                totalCustomersBoxFit++;
                totalRatingBoxFit += booking.getRating();
                numOfLessonsBoxFit++;
            } else if (booking.getLesson().getFitnessType().equalsIgnoreCase("Swimming")) {
                totalCustomersSwimming++;
                totalRatingSwimming += booking.getRating();
                numOfLessonsSwimming++;
            }

        }

        System.out.println("Number of customers Football: " + totalCustomersFootball);
        System.out.printf("Average rating Football: %.2f\n", (double) totalRatingFootball / numOfLessonsFootball);
        System.out.println("Number of customers Tennis: " + totalCustomersTennis);
        System.out.printf("Average rating Tennis: %.2f\n", (double) totalRatingTennis / numOfLessonsTennis);
        System.out.println("Number of customers Cycling: " + totalCustomersCycling);
        System.out.printf("Average rating Cycling: %.2f\n", (double) totalRatingCycling / numOfLessonsCycling);
        System.out.println("Number of customers BoxFit: " + totalCustomersBoxFit);
        System.out.printf("Average rating BoxFit: %.2f\n", (double) totalRatingBoxFit / numOfLessonsBoxFit);
        System.out.println("Number of customers Swimming: " + totalCustomersSwimming);
        System.out.printf("Average rating Swimming: %.2f\n", (double) totalRatingSwimming / numOfLessonsSwimming);
    }


//    public void printMonthlyChampionReport(int month) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (BookingFrame booking : bookingssDbArray) {
//            String fitnessType = booking.getLesson().getFitnessType();
//            if (map.containsKey(fitnessType)) {
//                int income = map.get(fitnessType);
//                income += booking.getLesson().getPrice();
//                map.put(fitnessType, income);
//            } else {
//                map.put(fitnessType, booking.getLesson().getPrice());
//            }
//        }
//        System.out.println("Monthly Champion Report for Month " + month);
//        for (String key : map.keySet()) {
//            System.out.println("Fitness Type: " + key + " Income: " + map.get(key));
//        }


        public void printChampionReport(int monthNumber) {


            HashMap<String, Integer> map = new HashMap<>();
            for (BookingFrame booking : bookingssDbArray) {
                String fitnessType = booking.getLesson().getFitnessType();
                if (map.containsKey(fitnessType)) {
                    int income = map.get(fitnessType);
                    income += booking.getLesson().getPrice();
                    map.put(fitnessType, income);
                } else {
                    map.put(fitnessType, booking.getLesson().getPrice());
                }
            }

            int maxIncome = 0;
            String championFitnessType = "";
            for (String key : map.keySet()) {
                if (map.get(key) > maxIncome) {
                    maxIncome = map.get(key);
                    championFitnessType = key;
                }
            }
            System.out.println("Champion is " + championFitnessType);
        }


        }
