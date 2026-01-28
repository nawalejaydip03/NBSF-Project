package com.jaydip.backends.repository;

import com.jaydip.backends.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStatus(Student.StudentStatus status);

    Long countByStatus(Student.StudentStatus status);

    List<Student> findByEmail(String email);

    List<Student> findByPhone(String phone);
}