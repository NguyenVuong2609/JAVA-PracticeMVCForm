package Rikkei.academy.view;

import Rikkei.academy.config.Config;
import Rikkei.academy.controller.StudentController;
import Rikkei.academy.model.Student;

import java.util.List;

public class StudentView {
    StudentController studentController = new StudentController();

    public void showTableStudent() {
        System.out.println("**************STUDENT MANAGEMENT*******************");
        List<Student> studentList = studentController.showListStudent();
        System.out.println("===ID===Name===Age===");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("   " + studentList.get(i).getId() + "   " + studentList.get(i).getName() + "   " + studentList.get(i).getAge());
        }
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void createStudentForm() {
        while (true) {
            List<Student> studentList = studentController.showListStudent();
            int id;
            if (studentList.size() > 0) {
                id = studentList.get(studentList.size() - 1).getId() + 1;
            } else {
                id = 1;
            }
            System.out.println("Enter the name: ");
            String name = Config.scanner().nextLine();
            System.out.println("Enter the age: ");
            int age = Integer.parseInt(Config.scanner().nextLine());
            Student student = new Student(id, name, age);
            studentController.createStudent(student);
            System.out.println("Create success!");
            System.out.println("Enter any key to continue or type -back- to come back Menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Main();
                break;
            }
        }
    }

    public void updateStudentForm() {
        List<Student> studentList = studentController.showListStudent();
        System.out.println(studentList);
        System.out.println("Enter the Student's ID that you want to edit: ");
        int id = Integer.parseInt(Config.scanner().nextLine());
        System.out.println("Enter new name: ");
        String newName = Config.scanner().nextLine();
        System.out.println("Enter new age: ");
        int newAge = Integer.parseInt(Config.scanner().nextLine());
        studentController.updateStudent(new Student(id, newName, newAge));
        System.out.println("Update success!");
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void deleteStudentForm() {
        List<Student> studentList = studentController.showListStudent();
        boolean checkId = true;
        System.out.println("Enter a Id that you want to delete: ");
        int updateId = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == updateId) {
                studentController.deleteStudent(updateId);
                System.out.println("Delete Success!");
                checkId = false;
            }
        }
        if (checkId)
            System.out.println("This ID does not exist");
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }
}
