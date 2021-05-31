package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
    private String email;
    private boolean email_approved;
    private String company_name;
    private String web_site;
    private String mobile;
    private boolean employerApproved;
}
