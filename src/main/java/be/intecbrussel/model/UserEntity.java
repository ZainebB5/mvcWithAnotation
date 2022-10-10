package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.Objects;
import jakarta.persistence.*;

import javax.validation.constraints.*;
import java.util.Objects;


@Entity


public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
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


    @Size(min = 8, max = 255, message = "Passwword must contain minimum 8 character !")
    @NotNull
    @Column(name = "hashed_password", nullable = false, length = 1000)
    private String hashedPassword;

    @Min(6)
    @Column(name = "validation", nullable = false, length = 8)
    private String validation;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public UserEntity() {
    }

    public UserEntity(String fName, String mName, String lName, String email, String hashedPassword, String validation, Boolean active) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.validation = validation;
        this.active = active;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}