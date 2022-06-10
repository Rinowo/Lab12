package exercise.ex1;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class StudentList {
    ArrayList<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public StudentList() {
        list.add(new Student("1", "Tùng Anh", 9.3));
        list.add(new Student("2", "Ngọc Anh", 4.3));
        list.add(new Student("3", "Mai Anh", 5.3));
    }

    public void addStudent(Student student) {
        this.list.add(student);
    }

    public void inputStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student mark: ");
        double mark = sc.nextDouble();
        Student student = new Student(id, name, mark);
        addStudent(student);
    }

    public void writeFile() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get("StudentList.json"));
        gson.toJson(list, writer);
        writer.close();
    }

    public void readFile() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("StudentList.json");
        list = new Gson().fromJson(reader, new TypeToken<List<Student>>() {
        }.getType());

        for (Student student :
                list) {
            System.out.println(student);
        }
    }
}
