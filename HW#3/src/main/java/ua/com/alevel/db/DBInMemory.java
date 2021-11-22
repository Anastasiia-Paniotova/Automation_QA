package ua.com.alevel.db;

import ua.com.alevel.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBInMemory {

    private final List<Student> students = new ArrayList<>();
    private final static DBInMemory instance = new DBInMemory();

    private DBInMemory() { }

    public static DBInMemory getInstance() {
        return instance;
    }

    public void insert(Student student) {
        student.setId(generateId());
        students.add(student);
    }

    public Student selectById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> selectAll() {
        return students;
    }

    public void delete(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void update(Student student) {
        for (Student current : students) {
            if (current.getId().equals(student.getId())) {
                current = student;
            }
        }
    }

    public boolean existByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
