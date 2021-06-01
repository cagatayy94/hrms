package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
    private String email;
    private String companyName;
    private String website;
    private String mobile;
    private String password;
    private String passwordRepeat;
}
