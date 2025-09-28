package com.EduLink.EduLink.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class LoginRequestDTO {
    @NotBlank(message = "نام کاربری نمی‌تواند خالی باشد")
    @Size(min = 4, max = 20, message = "نام کاربری باید بین 4 تا 20 کاراکتر باشد")
    private String username;

    @NotBlank(message = "ایمیل نمی‌تواند خالی باشد")
    @Email(message = "ایمیل وارد شده معتبر نیست")
    private String email;

    @NotBlank(message = "رمز عبور نمی‌تواند خالی باشد")
    @Size(min = 8, message = "رمز عبور باید حداقل 8 کاراکتر باشد")
    private String password;

}
