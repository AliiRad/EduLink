package com.EduLink.EduLink.model.entity;

import com.EduLink.EduLink.model.enums.Major;
import com.EduLink.EduLink.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "StudentEntity")
@Table(name = "student_tbl")
public class Student {

    @Id
    @SequenceGenerator(name = "StudentSequence",sequenceName = "student_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Integer id;

    @Column(name = "student_number", nullable = false, unique = true, length = 10)
    @NotBlank(message = "شماره دانشجویی نمی‌تواند خالی باشد")
    @Pattern(regexp = "^[0-9]{8,10}$", message = "شماره دانشجویی باید 8 تا 10 رقم باشد")
    private String studentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "major", nullable = false)
    @NotNull(message = "رشته تحصیلی نمی‌تواند خالی باشد")
    private Major major;

    @Min(value = 1380, message = "سال ورود نامعتبر است") // سال شمسی
    @Max(value = 1404, message = "سال ورود نامعتبر است")
    @Column(name = "enrollment_year", nullable = false)
    private Integer enrollmentYear;

    @DecimalMin(value = "0.0", message = "معدل نمی‌تواند منفی باشد")
    @DecimalMax(value = "20.0", message = "معدل نمی‌تواند بیشتر از 20 باشد")
    @Column(name = "gpa")
    private Double gpa;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @NotNull(message = "نقش کاربر باید مشخص شود")
    private Role role; // TODO : APPLICATION MUST DO THAT

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;// TODO : APPLICATION MUST DO THAT

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;// TODO : APPLICATION MUST DO THAT

    @OneToOne(fetch = FetchType.EAGER)
    private Person person;

}
