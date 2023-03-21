package Rikkei.academy.controller;

import Rikkei.academy.model.Student;
import Rikkei.academy.service.IStudentService;
import Rikkei.academy.service.StudentServiceIMPL;

import java.util.List;

public class StudentController {
    IStudentService studentService = new StudentServiceIMPL();
    public List<Student> showListStudent(){
        return studentService.findAll();
    }
    public void createStudent(Student student){
        studentService.save(student);
    }

    public void updateStudent(Student student){
        studentService.save(student);
    }

    public void deleteStudent(int id){
        studentService.deleteById(id);
    }
    public Student findStudentById(int id) {
        return studentService.findById(id);
    }
}
