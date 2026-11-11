package persistence;

import java.util.ArrayList;
import model.Student;

// Handles in-memory data storage using ArrayList.
public class StudentRepository {
    private final ArrayList<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Student student = findById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
