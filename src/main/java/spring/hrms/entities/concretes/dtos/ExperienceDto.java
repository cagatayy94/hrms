package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {
    private String position;
    private String companyName;
    private int startYear;
    private int endYear;
    private int userId;
}
