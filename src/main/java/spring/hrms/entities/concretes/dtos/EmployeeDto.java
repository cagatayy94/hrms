package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String surname;
    private String identificationNumber;
    private String birthday;
    private String email;
    private String password;
    private String passwordRepeat;
}
