package Rikkei.academy.service;

import Rikkei.academy.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student); //! Thêm mới.
    Student findById(int id); //! Tìm đối tượng bằng ID.
    void deleteById(int id); //! Xóa đối tượng bằng ID.
}
