package com.EduLink.EduLink.model.service;

import com.EduLink.EduLink.model.entity.Student;
import com.EduLink.EduLink.model.repositroy.StudentRepository;
import com.EduLink.EduLink.model.service.impl.ServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements ServiceImpl<Student,Long> {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    @Transactional
    public Student insert(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    @Transactional
    public Student update(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    @Transactional
    public Student delete(Student student) {
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).isPresent() ? studentRepository.findById(id).get() : null;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAll(String condition) {
        return null;
    }

    @Override
    public List<Student> findAll(String condition, String order) {
        return null;
    }
}
