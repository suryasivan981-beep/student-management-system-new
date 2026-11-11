package businesslogic;

import java.util.ArrayList;
import model.Student;
import persistence.StudentRepository;

// Contains the application's rules and operations.
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public boolean addStudent(int id, String name, int age) {
        if (id <= 0 || name == null || name.trim().isEmpty() || age <= 0) {
            return false;
        }
        if (repository.findById(id) != null) {
            return false; // Student ID must be unique.
        }

        repository.add(new Student(id, name.trim(), age));
        return true;
    }

    public ArrayList<Student> getAllStudents() {
        return repository.getAll();
    }

    public boolean updateStudent(int id, String name, int age) {
        if (name == null || name.trim().isEmpty() || age <= 0) {
            return false;
        }

        Student student = repository.findById(id);
        if (student == null) {
            return false;
        }

        student.setName(name.trim());
        student.setAge(age);
        return true;
    }

    public boolean deleteStudent(int id) {
        return repository.delete(id);
    }
}
