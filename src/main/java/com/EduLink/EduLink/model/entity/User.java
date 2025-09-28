package com.EduLink.EduLink.model.entity;

import com.EduLink.EduLink.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "UserEntity")
@Table(name = "user_tbl")
public class User {

    @Id
    @SequenceGenerator(name = "UserSequence",sequenceName = "user_seq", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

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

    @Size(max = 255, message = "آدرس تصویر نباید بیش از 255 کاراکتر باشد")
    private String profilePictureUrl; // TODO : LATER ADD THIS

    @PastOrPresent(message = "تاریخ عضویت باید در گذشته یا حال باشد")
    private Date joinDate; // TODO: APPLICATION MUST DO THAT

    @PastOrPresent(message = "آخرین زمان ورود باید در گذشته یا حال باشد")
    private Date lastLogin; // TODO: APPLICATION MUST DO THAT

    @NotNull(message = "وضعیت حساب باید مشخص شود")
    // TODO: APPLICATION MUST DO THAT
    private Status status; // می‌توانید enum بسازید: ACTIVE, INACTIVE, BLOCKED


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // TODO: APPLICATION MUST DO THAT
    private Person person;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // TODO: APPLICATION MUST DO THAT
    private Student student;
}