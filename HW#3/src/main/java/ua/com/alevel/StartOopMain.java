package ua.com.alevel;

import ua.com.alevel.controller.StudentController;

import java.io.IOException;

public class StartOopMain {

    public static void main(String[] args) throws IOException {
        StudentController controller = new StudentController();
        controller.run();
    }
}
