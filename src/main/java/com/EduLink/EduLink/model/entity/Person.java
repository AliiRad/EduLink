package com.EduLink.EduLink.model.entity;

import com.EduLink.EduLink.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "PersonEntity")
@Table(name = "person_tbl")
public class Person {

    @Id
    @SequenceGenerator(name = "PersonSequence",sequenceName = "person_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_seq")
    private Long id;

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



}
