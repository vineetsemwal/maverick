package org.example.registry.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

}
