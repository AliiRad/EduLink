package com.EduLink.EduLink.controller;

import com.EduLink.EduLink.config.Jalali;
import com.EduLink.EduLink.model.DTO.RegisterDTO;
import com.EduLink.EduLink.model.entity.Person;
import com.EduLink.EduLink.model.entity.Student;
import com.EduLink.EduLink.model.entity.User;
import com.EduLink.EduLink.model.enums.Role;
import com.EduLink.EduLink.model.enums.Status;
import com.EduLink.EduLink.model.service.PersonService;
import com.EduLink.EduLink.model.service.StudentService;
import com.EduLink.EduLink.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/student")
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody(required = true) RegisterDTO registerDTO) {
        Person person = Person.builder()
                .name(registerDTO.getName())
                .family(registerDTO.getFamily())
                .gender(registerDTO.getGender())
                .birthday(registerDTO.getBirthday())
                .build();

        Student student = Student.builder()
                .studentNumber(registerDTO.getStudentNumber())
                .major(registerDTO.getMajor())
                .enrollmentYear(registerDTO.getEnrollmentYear())
                .gpa(registerDTO.getGpa())
                .role(Role.USTUDENT)
                .createdAt(null)
                .person(person)
                .build();

        User user = User.builder()
                .username(registerDTO.getUsername())
                .password(registerDTO.getPassword())
                .nickname(registerDTO.getNickname())
                .email(registerDTO.getEmail())
                .phoneNumber(registerDTO.getPhoneNumber())
                .profilePictureUrl(null)
                .joinDate(null)
                .lastLogin(null)
                .status(Status.INACTIVE)
                .person(person)
                .student(student)
                .build();

        if (userService.insert(user)!=null){
            return ResponseEntity.ok("Student Registered Successfully");
        }else{
            return ResponseEntity.badRequest().body("Student Register Failed - Check Fields");
        }

    }

}
