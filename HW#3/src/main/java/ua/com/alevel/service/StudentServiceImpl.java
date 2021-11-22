package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void create(Student student) {
        if (!studentDao.existByEmail(student.getEmail())) {
            studentDao.create(student);
        }
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
        studentDao.delete(id);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
