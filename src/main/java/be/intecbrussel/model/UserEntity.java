package be.intecbrussel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity


public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name is required ! ")
    @NotNull
    @Column(name = "f_name")
    private String fName;

    @Column(name = "m_name")
    private String mName;

    @NotBlank(message = "Name is required ! ")
    @NotNull
    @Column(name = "l_name")
    private String lName;

    @Email
    @NotNull
    @Column(name = "email", nullable = false, unique = true , length = 1000)
    private String email;


    @Min(8) @Max(255)
    @NotNull
    @Column(name = "hashed_password", nullable = false, length = 1000)
    private String hashedPassword;

    @Min(6) @Max(8)
    @Column(name = "validation", nullable = false, length = 8)
    private String validation;

    @Column(name = "active", nullable = false)
    private Boolean active = false;


}