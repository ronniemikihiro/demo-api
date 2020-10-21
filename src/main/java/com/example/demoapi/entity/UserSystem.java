package com.example.demoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_system")
public class UserSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String username;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_system_role", joinColumns = @JoinColumn(name = "id_user")
            , inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;

}
