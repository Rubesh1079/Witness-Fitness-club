package com.assignment.FC;

import java.util.Scanner;
public class Details {
        public static void main(String[] args) {
            CustomerLogic customer1 = new CustomerLogic("Harry", "harry@gmail.com");
            CustomerLogic customer2 = new CustomerLogic("James", "james@gmail.com");
            CustomerLogic customer3 = new CustomerLogic("Lily", "lily@gmail.com");
            CustomerLogic customer4 = new CustomerLogic("Jack", "jack@gmail.com");
            CustomerLogic customer5 = new CustomerLogic("Oliver", "oliver@gmail.com");

            SessionLogic[] lessons = new SessionLogic[32];

            lessons[0] = new SessionLogic("Football", "Saturday", "Weekend 1", 4);
            lessons[1] = new SessionLogic("Tennis", "Saturday", "Weekend 1", 4);
            lessons[2] = new SessionLogic("Cycling", "Saturday", "Weekend 1", 8);
            lessons[3] = new SessionLogic("BoxFit", "Saturday", "Weekend 1", 6);
            lessons[4] = new SessionLogic("Swimming", "Sunday", "Weekend 1", 8);
            lessons[5] = new SessionLogic("Cycling", "Sunday", "Weekend 1", 8);
            lessons[6] = new SessionLogic("Football", "Sunday", "Weekend 1", 4);
            lessons[7] = new SessionLogic("BoxFit", "Sunday", "Weekend 1", 6);
            lessons[8] = new SessionLogic("Football", "Saturday", "Weekend 2", 4);
            lessons[9] = new SessionLogic("Tennis", "Saturday", "Weekend 2", 4);
            lessons[10] = new SessionLogic("Cycling", "Saturday", "Weekend 2", 8);
            lessons[11] = new SessionLogic("BoxFit", "Saturday", "Weekend 2", 6);
            lessons[12] = new SessionLogic("Swimming", "Sunday", "Weekend 2", 8);
            lessons[13] = new SessionLogic("Cycling", "Sunday", "Weekend 2", 8);
            lessons[14] = new SessionLogic("Football", "Sunday", "Weekend 2", 4);
            lessons[15] = new SessionLogic("BoxFit", "Sunday", "Weekend 2", 6);
            lessons[16] = new SessionLogic("Football", "Saturday", "Weekend 3", 4);
            lessons[17] = new SessionLogic("Tennis", "Saturday", "Weekend 3", 4);
            lessons[18] = new SessionLogic("Cycling", "Saturday", "Weekend 3", 8);
            lessons[19] = new SessionLogic("BoxFit", "Saturday", "Weekend 3", 6);
            lessons[20] = new SessionLogic("Swimming", "Sunday", "Weekend 3", 8);
            lessons[21] = new SessionLogic("Cycling", "Sunday", "Weekend 3", 8);
            lessons[22] = new SessionLogic("Football", "Sunday", "Weekend 3", 4);
            lessons[23] = new SessionLogic("BoxFit", "Sunday", "Weekend 3", 6);
            lessons[24] = new SessionLogic("Football", "Saturday", "Weekend 4", 4);
            lessons[25] = new SessionLogic("Tennis", "Saturday", "Weekend 4", 4);
            lessons[26] = new SessionLogic("Cycling", "Saturday", "Weekend 4", 8);
            lessons[27] = new SessionLogic("BoxFit", "Saturday", "Weekend 4", 6);
            lessons[28] = new SessionLogic("Swimming", "Sunday", "Weekend 4", 8);
            lessons[29] = new SessionLogic("Football", "Saturday", "Weekend 4", 4);
            lessons[30] = new SessionLogic("Tennis", "Saturday", "Weekend 4", 4);
            lessons[31] = new SessionLogic("Cycling", "Saturday", "Weekend 4", 8);

            MainFrame mainFrame = new MainFrame(customer1, customer2, customer3, customer4, customer5, SessionLogic);

            mainFrame.mainFrameFC();



        }
    }
}
