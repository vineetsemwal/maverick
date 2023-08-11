package org.example.demo.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(of="id")
@Data
@Table(name = "usersdata")
@Entity
public class User {
    @Column(name="user_id")
    @GeneratedValue
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false,name="password_hash")
    private String password;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
