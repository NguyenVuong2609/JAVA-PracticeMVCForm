package Rikkei.academy.service;

import Rikkei.academy.model.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
