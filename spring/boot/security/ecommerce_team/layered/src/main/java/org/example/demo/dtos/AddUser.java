package org.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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
