package ua.com.alevel.dao;

import ua.com.alevel.db.DBInMemory;
import ua.com.alevel.entity.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final DBInMemory db = DBInMemory.getInstance();

    @Override
    public void create(Student student) {
        db.insert(student);
    }

    @Override
    public void update(Student student) {
        db.update(student);
    }

    @Override
    public void delete(String id) {
        db.delete(id);
    }

    @Override
    public Student findById(String id) {
        return db.selectById(id);
    }

    @Override
    public List<Student> findAll() {
        return db.selectAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return db.existByEmail(email);
    }
}
