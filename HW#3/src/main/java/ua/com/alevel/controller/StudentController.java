package ua.com.alevel.controller;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentController {

    private final StudentService service = new StudentServiceImpl();

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your options:");
        menu();
        String option;
        while ((option = reader.readLine()) != null) {
            switchToCrudOperations(option, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("if you want create, please enter 1");
        System.out.println("if you want update, please enter 2");
        System.out.println("if you want delete, please enter 3");
        System.out.println("if you want select Student, please enter 4");
        System.out.println("if you want select all Student, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void switchToCrudOperations(String option, BufferedReader reader) throws IOException {
        switch (option) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
            default -> System.out.println("incorrect input value");
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("StudentController.create");
        System.out.println("Please, enter age:");
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        System.out.println("Please, enter name:");
        String name = reader.readLine();
        System.out.println("Please, enter email:");
        String email = reader.readLine();
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        student.setEmail(email);
        service.create(student);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("StudentController.update");
        System.out.println("Please, enter id:");
        String id = reader.readLine();
        Student student = service.findById(id);
        System.out.println("Please, enter age:");
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        System.out.println("Please, enter name:");
        String name = reader.readLine();
        student.setAge(age);
        student.setName(name);
        service.update(student);
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("StudentController.delete");
        System.out.println("Please, enter id:");
        String id = reader.readLine();
        service.delete(id);
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("StudentController.findById");
        System.out.println("Please, enter id:");
        String id = reader.readLine();
        Student student = service.findById(id);
        System.out.println("Student = " + student);
    }

    private void findAll() {
        System.out.println("StudentController.findAll");
        List<Student> students = service.findAll();
        for (Student student : students) {
            System.out.println("Student = " + student);
        }
    }
}
