package com.EduLink.EduLink.model.DTO;

import com.EduLink.EduLink.model.enums.Gender;
import com.EduLink.EduLink.model.enums.Major;
import com.EduLink.EduLink.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegisterDTO {

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    @Size(min = 2, max = 50, message = "نام باید بین 2 تا 50 کاراکتر باشد")
    private String name;

    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    @Size(min = 2, max = 50, message = "نام خانوادگی باید بین 2 تا 50 کاراکتر باشد")
    private String family;

    @NotNull(message = "جنسیت باید مشخص شود")
    private Gender gender;

    @NotNull(message = "تاریخ تولد نمی‌تواند خالی باشد")
    @Past(message = "تاریخ تولد باید در گذشته باشد")
    private Date birthday;


    @NotBlank(message = "نام کاربری نمی‌تواند خالی باشد")
    @Size(min = 4, max = 20, message = "نام کاربری باید بین 4 تا 20 کاراکتر باشد")
    private String username;

    @NotBlank(message = "رمز عبور نمی‌تواند خالی باشد")
    @Size(min = 8, message = "رمز عبور باید حداقل 8 کاراکتر باشد")
    private String password;

    @Size(max = 30, message = "نام مستعار نمی‌تواند بیش از 30 کاراکتر باشد")
    private String nickname;

    @NotBlank(message = "ایمیل نمی‌تواند خالی باشد")
    @Email(message = "ایمیل وارد شده معتبر نیست")
    private String email;

    @Pattern(
            regexp = "^(\\+98|0)?9\\d{9}$",
            message = "شماره تلفن باید معتبر و مطابق فرمت ایران باشد"
    )
    private String phoneNumber;

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
}
