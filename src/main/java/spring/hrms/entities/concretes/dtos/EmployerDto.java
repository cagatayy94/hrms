package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String companyName;

    @NotBlank
    @NotNull
    private String website;

    @NotBlank
    @NotNull
    private String mobile;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String passwordRepeat;
}
