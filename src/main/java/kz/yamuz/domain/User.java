package kz.yamuz.domain;

import com.sun.istack.NotNull;
import kz.yamuz.security.ValidPassword;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @ValidPassword
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private Status status;
}
