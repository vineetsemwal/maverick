package org.example.registry.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class AppUserDetails {
    private Long id;
    private String username;
    private String roles;
    private String email;
}
