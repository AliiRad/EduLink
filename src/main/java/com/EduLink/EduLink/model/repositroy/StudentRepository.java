package com.EduLink.EduLink.model.repositroy;

import com.EduLink.EduLink.model.entity.Student;
import com.sun.jdi.InterfaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
