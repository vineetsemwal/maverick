package org.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
public class AppUserDetails {
    private Long id;
    private String username;
    private String roles;
    private String email;
}
