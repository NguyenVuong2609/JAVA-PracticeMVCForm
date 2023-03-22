package Rikkei.academy.view;

import Rikkei.academy.service.StudentComparator;
import Rikkei.academy.config.Config;
import Rikkei.academy.controller.StudentController;
import Rikkei.academy.model.Student;

import java.util.Collections;
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
                id = findMaxId() + 1;
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
        if (studentController.findStudentById(id) != null) {
            System.out.println("Enter new name: ");
            String newName = Config.scanner().nextLine();
            System.out.println("Enter new age: ");
            int newAge = Integer.parseInt(Config.scanner().nextLine());
            studentController.updateStudent(new Student(id, newName, newAge));
            System.out.println("Update success!");
        } else {
            System.out.println("This ID does not exist");
        }
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void deleteStudentForm() {
        System.out.println("Enter a Id that you want to delete: ");
        int deleteId = Integer.parseInt(Config.scanner().nextLine());
        if (studentController.findStudentById(deleteId) != null) {
            studentController.deleteStudent(deleteId);
            System.out.println("Delete Success!");
        } else {
            System.out.println("This ID does not exist");
        }
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void sortStudentByName(){
        StudentComparator studentComparator = new StudentComparator();
        List<Student> studentList = studentController.showListStudent();
        Collections.sort(studentList,studentComparator);
        System.out.println("Sort success!");
        System.out.println("Enter any key to exit or type -back- to come back Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public int findMaxId(){
        List<Student> studentList = studentController.showListStudent();
        int max = studentList.get(0).getId();
        for (int i = 1; i < studentList.size(); i++) {
            if (max < studentList.get(i).getId()){
                max = studentList.get(i).getId();
            }
        }
        return max;
    }
}
