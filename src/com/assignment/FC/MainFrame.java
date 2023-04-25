package com.assignment.FC;

import java.util.Scanner;

public class MainFrame {
    private CustomerLogic customer1, customer2,customer3,customer4,customer5;
    private SessionLogic[] session;
    Scanner scanner = new Scanner(System.in);
    SystemLogic bookingSystem = new SystemLogic();

    String commonUserName;
    public MainFrame(CustomerLogic customer1, CustomerLogic customer2, CustomerLogic customer3, CustomerLogic customer4, CustomerLogic customer5, SessionLogic[] session) {

        this.customer1 = customer1;
        this.customer2 = customer2;
        this.customer3 = customer3;
        this.customer4 = customer4;
        this.customer5 = customer5;
        this.session = session;

    }
    public void viewMenuByDay(){
        System.out.print("Enter day (Saturday/Sunday): ");
        String daySelected = scanner.nextLine().trim();
        System.out.printf("%-10s %-10s %-10s %-10s %-10s \n", "Day", "Lesson", "Weekend", "Spot Left", "Price");
        for (SessionLogic lesson : session) {
            lesson.viewLessonByDay(daySelected);
        }
    }

    public void viewMenuByFitnessType(){
        System.out.println("Select the available Fitness Types (Yoga/Spin/Pilates/Crossfit/Boxing)");
        String fitnessTypeSelected = scanner.nextLine().trim();
        System.out.printf("%-10s %-10s %-10s %-10s %-10s \n", "Lesson", "Day", "Weekend", "Spot Left", "Price");
        for (SessionLogic lesson : session) {
            lesson.viewLessonByFitnessType(fitnessTypeSelected);
        }
    }
    public void bookLessonMainMenu(){

        System.out.print("Enter lesson name: ");
        String lessonName = scanner.nextLine().trim();
        System.out.print("Enter the day (Saturday/Sunday): ");
        String lessonDay = scanner.nextLine().trim();
        System.out.print("Enter the weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String lessonWeekend = scanner.nextLine().trim();

        // validate if customer and lesson are part of database
        CustomerLogic isCustomer = null;
        for (CustomerLogic c : new CustomerLogic[]{customer1, customer2, customer3, customer4, customer5}) {
            if (c.getName().equalsIgnoreCase(commonUserName)) {
                isCustomer = c;
                break;
            }
        }

        SessionLogic isLesson = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(lessonName) && l.getDay().equalsIgnoreCase(lessonDay)
                    && l.getWeekend().equalsIgnoreCase(lessonWeekend)) {
                isLesson = l;
                break;
            }
        }

        // book lesson if customer and lesson are valid
        if (isCustomer != null && isLesson != null) {
            bookingSystem.bookLesson(isCustomer, isLesson);
        } else {
            System.out.println("Invalid customer or lesson.");
        }
    }
    public void cancelLessonMainMenu(){
        System.out.print("Enter lesson name: ");
        String lessonNameToCancel = scanner.nextLine().trim();
        System.out.print("Enter the day (Saturday/Sunday): ");
        String lessonDayToCancel = scanner.nextLine().trim();
        System.out.print("Enter the weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String lessonWeekendToCancel = scanner.nextLine().trim();
        SessionLogic isLessonToCancel = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(lessonNameToCancel) && l.getDay().equalsIgnoreCase(lessonDayToCancel)
                    && l.getWeekend().equalsIgnoreCase(lessonWeekendToCancel)) {
                isLessonToCancel = l;
                break;
            }
        }
        if (isLessonToCancel != null) {
            int index = bookingSystem.getBookingIndex(commonUserName, lessonNameToCancel,lessonDayToCancel, lessonWeekendToCancel );
            if (index != -1) {
                BookingFrame unwantedBooking = bookingSystem.getBookings().get(index);
                bookingSystem.cancelBooking(unwantedBooking);
            } else {
                System.out.println("Booking not found.");
            }
        } else {
            System.out.println("Invalid customer or lesson.");
        }
    }
    public void changeLessonMainMenu() {
//        System.out.print("Enter customer full name: ");
//                    String customerNameToChange = scanner.nextLine();
        System.out.print("Enter lesson name: ");
        String lessonNameToChange = scanner.nextLine().trim();
        System.out.print("Enter the day (Saturday/Sunday): ");
        String lessonDayToChange = scanner.nextLine().trim();
        System.out.print("Enter the weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String lessonWeekendToChange = scanner.nextLine().trim();
        SessionLogic isLessonToChange = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(lessonNameToChange) && l.getDay().equalsIgnoreCase(lessonDayToChange)
                    && l.getWeekend().equalsIgnoreCase(lessonWeekendToChange)) {
                isLessonToChange = l;
                break;
            }
        }

//                    Booking new Lesson
        System.out.print("Enter new lesson name: ");
        String newLessonName = scanner.nextLine().trim();
        System.out.print("Enter the new day (Saturday/Sunday): ");
        String newLessonDay = scanner.nextLine().trim();
        System.out.print("Enter the new weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String newLessonWeekend = scanner.nextLine().trim();


        SessionLogic newBookingLesson = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(newLessonName) && l.getDay().equalsIgnoreCase(newLessonDay)
                    && l.getWeekend().equalsIgnoreCase(newLessonWeekend)) {
                newBookingLesson = l;
                break;
            }
        }



        if (isLessonToChange != null && newBookingLesson != null) {
            int index = bookingSystem.getBookingIndex(commonUserName, lessonNameToChange,lessonDayToChange, lessonWeekendToChange );
            if (index != -1) {
                BookingFrame oldBooking = bookingSystem.getBookings().get(index);
                bookingSystem.changeBooking(oldBooking, newBookingLesson);
            } else {
                System.out.println("Booking not found.");
            }
        } else {
            System.out.println("Invalid customer or lesson.");
        }
    }
    public void  rateLessonMainMenu() {
        System.out.print("Enter lesson name you want to rate: ");
        String lessonNameToRate = scanner.nextLine().trim();
        System.out.print("Enter which day (Saturday/Sunday): ");
        String lessonDayToRate = scanner.nextLine().trim();
        System.out.print("Enter which weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String lessonWeekendToRate = scanner.nextLine().trim();
        System.out.print("Enter rating on a scale of 1 to 5: ");
        int ratingByCustomer = scanner.nextInt();
        scanner.nextLine();
        SessionLogic isLessonToRate = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(lessonNameToRate) && l.getDay().equalsIgnoreCase(lessonDayToRate)
                    && l.getWeekend().equalsIgnoreCase(lessonWeekendToRate)) {
                isLessonToRate = l;
                break;
            }
        }
        if (isLessonToRate != null) {
            int index = bookingSystem.getBookingIndex(commonUserName, lessonNameToRate,lessonDayToRate, lessonWeekendToRate );
            if (index != -1) {
                BookingFrame bookingToRate = bookingSystem.getBookings().get(index);
                bookingSystem.rateLesson(bookingToRate, ratingByCustomer);
            } else {
                System.out.println("Booking not found.");
            }
        } else {
            System.out.println("Invalid customer or lesson.");
        }

    }

    public void attendLesson(){
//        System.out.print("Enter customer full name: ");
//        String customerNameToAttend = scanner.nextLine();
        System.out.print("Enter lesson name you want to attend: ");
        String lessonNameToAttend = scanner.nextLine().trim();
        System.out.print("Enter which day (Saturday/Sunday): ");
        String lessonDayToAttend = scanner.nextLine().trim();
        System.out.print("Enter which weekend (Weekend 1/Weekend 2/Weekend 3/Weekend 4): ");
        String lessonWeekendToAttend = scanner.nextLine().trim();

        SessionLogic isLessonToAttend = null;
        for (SessionLogic l : session) {
            if (l.getFitnessType().equalsIgnoreCase(lessonNameToAttend) && l.getDay().equalsIgnoreCase(lessonDayToAttend)
                    && l.getWeekend().equalsIgnoreCase(lessonWeekendToAttend)) {
                isLessonToAttend = l;
                break;
            }
        }
        if (isLessonToAttend != null) {
            int index = bookingSystem.getBookingIndex(commonUserName, lessonNameToAttend,lessonDayToAttend, lessonWeekendToAttend );
            if (index != -1) {
                bookingSystem.getBookings().get(index).setAttended(true);
                System.out.println("You have successfully completed this lesson");
            } else {
                System.out.println("Booking not found.");
            }
        } else {
            System.out.println("Invalid customer or lesson.");
        }
    }



    public void  viewMonthlyReportMainMenu() {
        bookingSystem.printMonthlyLessonReport(1);
    }

    public void  viewChampionReportMainMenu() {
        bookingSystem.printChampionReport(1);
    }


    public void viewBookingDBArray(){
        bookingSystem.viewBookingDb();
    }


    public void bookLessonWFC(){
        boolean exit = false;

        while (!exit) {
            System.out.println("Options for Booking\n");

            System.out.println("Please select any option:");
            System.out.println("1. View lessons by day");
            System.out.println("2. View lessons by fitness type");
            System.out.println("3. Book a lesson");
            System.out.println("4. Go to main menu");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (customerChoice) {
                case 1:
                    viewMenuByDay();
                    break;

                case 2:
                    viewMenuByFitnessType();
                    break;

                case 3:
                    bookLessonMainMenu();
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }


        }
    }

    public void updateBookingWFC(){
        boolean exit = false;

        while (!exit) {
            System.out.println("Options to Update Booking\n");

            System.out.println("Please select any option:");
            System.out.println("1. Change booking");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Go to main menu");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (customerChoice) {
                case 1:
                    changeLessonMainMenu();
                    break;

                case 2:
                    cancelLessonMainMenu();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
                    break;
            }


        }
    }





    public void attendLessonWFC(){
        boolean exit = false;

        while (!exit) {
            System.out.println("Options to Attend Lesson\n");

            System.out.println("Please select any option:");
            System.out.println("1. Attend Lesson");
            System.out.println("2. Rate a Lesson");
            System.out.println("3. Go to main menu");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (customerChoice) {
                case 1:
                    attendLesson();
                    break;

                case 2:
                    rateLessonMainMenu();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
                    break;
            }


        }
    }


    public void displayReportWFC(){
        boolean exit = false;

        while (!exit) {
            System.out.println("Options to View Report\n");

            System.out.println("Please select any option:");
            System.out.println("1. View Monthly Report");
            System.out.println("2. View Champion of the month");
            System.out.println("3. Go to main menu");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (customerChoice) {
                case 1:
                    viewMonthlyReportMainMenu();
                    break;

                case 2:
                    viewChampionReportMainMenu();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
                    break;
            }


        }
    }
    public void mainFrameFC(){

        System.out.println("Please enter you full name");
        String userName = scanner.nextLine();
        CustomerLogic isCustomerInDb = null;
        for (CustomerLogic c : new CustomerLogic[]{customer1, customer2, customer3, customer4, customer5}) {
            if (c.getName().equalsIgnoreCase(userName)) {
                isCustomerInDb = c;
                break;
            }
        }
        if (isCustomerInDb != null) {
            commonUserName = userName;

            System.out.println("Hii "+commonUserName.toUpperCase()+"! Welcome to Weekend Fitness Club.");

            boolean exit = false;

            while (!exit) {
                System.out.println("Please select any option:");
                System.out.println("1. Booking a lesson");
                System.out.println("2. Update your booking");
                System.out.println("3. Attend a lesson");
                System.out.println("4. Display report");
                System.out.println("5. Exit WFC");
                System.out.println("6. view bookingDbArray");
                int customerChoice = scanner.nextInt();
                scanner.nextLine();


                switch (customerChoice) {
                    case 1:
                        // View lessons by day
                        bookLessonWFC();
                        break;

                    case 2:
                        // View lessons by fitness type
                        updateBookingWFC();
                        break;

                    case 3:
                        // Book a Lesson
                        attendLessonWFC();
                        break;

                    case 4:
                        // Cancel Booking
                        displayReportWFC();
                        break;

                    case 5:
                        System.out.println("Bye. See you later.");
                        return;

                    case 6:
                        // View db
                        viewBookingDBArray();
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 8.");
                        break;
                }

                System.out.print("Continue Main Menu (y/n)?: ");
                String continueChoice = scanner.nextLine().trim();
                if (!continueChoice.equalsIgnoreCase("y")) {
                    exit = true;
                }
            }
        } else {
            System.out.println("Sorry "+userName+" is not registered to our system.");
        }

    }

}









