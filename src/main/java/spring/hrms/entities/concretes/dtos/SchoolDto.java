package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private String name;
    private String department;
    private int startYear;
    private int endYear;
    private int userId;
}
