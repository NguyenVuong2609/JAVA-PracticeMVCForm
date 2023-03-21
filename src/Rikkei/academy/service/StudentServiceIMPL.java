package Rikkei.academy.service;

import Rikkei.academy.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    public static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Van", 10));
        studentList.add(new Student(2, "Yen", 15));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        boolean checkId = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == student.getId()) {
                studentList.set(i, student);
                checkId = true;
            }
        }
        if (!checkId)
            studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
            }
        }
    }
}
