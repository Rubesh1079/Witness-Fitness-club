package com.assignment.FC;

import java.util.Scanner;
public class Details {
        public static void main(String[] args) {
            CustomerLogic customer1 = new CustomerLogic("Harry", "harry@gmail.com");
            CustomerLogic customer2 = new CustomerLogic("James", "james@gmail.com");
            CustomerLogic customer3 = new CustomerLogic("Lily", "lily@gmail.com");
            CustomerLogic customer4 = new CustomerLogic("Jack", "jack@gmail.com");
            CustomerLogic customer5 = new CustomerLogic("Oliver", "oliver@gmail.com");

            SessionLogic[] session = new SessionLogic[32];

            session[0] = new SessionLogic("Football", "Saturday", "Weekend 1", 4);
            session[1] = new SessionLogic("Tennis", "Saturday", "Weekend 1", 4);
            session[2] = new SessionLogic("Cycling", "Saturday", "Weekend 1", 8);
            session[3] = new SessionLogic("BoxFit", "Saturday", "Weekend 1", 6);
            session[4] = new SessionLogic("Swimming", "Sunday", "Weekend 1", 8);
            session[5] = new SessionLogic("Cycling", "Sunday", "Weekend 1", 8);
            session[6] = new SessionLogic("Football", "Sunday", "Weekend 1", 4);
            session[7] = new SessionLogic("BoxFit", "Sunday", "Weekend 1", 6);
            session[8] = new SessionLogic("Football", "Saturday", "Weekend 2", 4);
            session[9] = new SessionLogic("Tennis", "Saturday", "Weekend 2", 4);
            session[10] = new SessionLogic("Cycling", "Saturday", "Weekend 2", 8);
            session[11] = new SessionLogic("BoxFit", "Saturday", "Weekend 2", 6);
            session[12] = new SessionLogic("Swimming", "Sunday", "Weekend 2", 8);
            session[13] = new SessionLogic("Cycling", "Sunday", "Weekend 2", 8);
            session[14] = new SessionLogic("Football", "Sunday", "Weekend 2", 4);
            session[15] = new SessionLogic("BoxFit", "Sunday", "Weekend 2", 6);
            session[16] = new SessionLogic("Football", "Saturday", "Weekend 3", 4);
            session[17] = new SessionLogic("Tennis", "Saturday", "Weekend 3", 4);
            session[18] = new SessionLogic("Cycling", "Saturday", "Weekend 3", 8);
            session[19] = new SessionLogic("BoxFit", "Saturday", "Weekend 3", 6);
            session[20] = new SessionLogic("Swimming", "Sunday", "Weekend 3", 8);
            session[21] = new SessionLogic("Cycling", "Sunday", "Weekend 3", 8);
            session[22] = new SessionLogic("Football", "Sunday", "Weekend 3", 4);
            session[23] = new SessionLogic("BoxFit", "Sunday", "Weekend 3", 6);
            session[24] = new SessionLogic("Football", "Saturday", "Weekend 4", 4);
            session[25] = new SessionLogic("Tennis", "Saturday", "Weekend 4", 4);
            session[26] = new SessionLogic("Cycling", "Saturday", "Weekend 4", 8);
            session[27] = new SessionLogic("BoxFit", "Saturday", "Weekend 4", 6);
            session[28] = new SessionLogic("Swimming", "Sunday", "Weekend 4", 8);
            session[29] = new SessionLogic("Football", "Saturday", "Weekend 4", 4);
            session[30] = new SessionLogic("Tennis", "Saturday", "Weekend 4", 4);
            session[31] = new SessionLogic("Cycling", "Saturday", "Weekend 4", 8);

            MainFrame mainFrame = new MainFrame(customer1, customer2, customer3, customer4, customer5, session);

            mainFrame.mainFrameFC();



        }
    }

