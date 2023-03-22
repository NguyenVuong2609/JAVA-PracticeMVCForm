package Rikkei.academy.view;

import Rikkei.academy.config.Config;


public class Main {
    public Main() {
        System.out.println("*************************STUDENT MANAGEMENT*****************************");
        System.out.println("1. Show List Student");
        System.out.println("2. Create Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Sort Student By Name");
        System.out.println("6. Exit");
        System.out.println("Please Enter Your Choice");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                new StudentView().showTableStudent();
                break;
            case 2:
                new StudentView().createStudentForm();
                break;
            case 3:
                new StudentView().updateStudentForm();
                break;
            case 4:
                new StudentView().deleteStudentForm();
                break;
            case 5:
                new StudentView().sortStudentByName();
                break;
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
