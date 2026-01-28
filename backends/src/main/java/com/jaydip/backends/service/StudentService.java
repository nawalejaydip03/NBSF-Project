package com.jaydip.backends.service;

import com.jaydip.backends.model.Student;
import com.jaydip.backends.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setFullName(student.getFullName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setStatus(student.getStatus());

        return studentRepository.save(existing);
    }

    public Map<String, Object> getStatistics() {
        long total = studentRepository.count();
        long pending = studentRepository.countByStatus(Student.StudentStatus.PENDING);
        long enrolled = studentRepository.countByStatus(Student.StudentStatus.ENROLLED);
        long completed = studentRepository.countByStatus(Student.StudentStatus.COMPLETED);
        long placed = studentRepository.countByStatus(Student.StudentStatus.PLACED);

        return Map.of(
                "total", total,
                "pending", pending,
                "enrolled", enrolled,
                "completed", completed,
                "placed", placed);
    }
}