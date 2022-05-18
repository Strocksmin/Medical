package com.example.medical.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserData implements Serializable {
    @NotEmpty(message = "Поле имени не может быть пустым")
    private String name;

    @NotEmpty(message = "Поле почты не может быть пустым")
    @Email(message = "Пожалуйста используйте валидную почту")
    private String email;

    @Pattern(regexp = "\\+7[0-9]{10}",
            message = "Формат поля телефона: +7xxxxxxxxxx")
    @NotEmpty(message = "Поле телефона не может быть пустым")
    private String phone;

    private String medic;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateTime=" + dateTime +
                ", medic=" + medic + '}';
    }
}