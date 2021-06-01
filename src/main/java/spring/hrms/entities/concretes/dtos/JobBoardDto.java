package spring.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobBoardDto {
    private int cityId;
    private String description;
    private Date dueDate;
    private int employerId;
    private int maxSalary;
    private int minSalary;
    private int openPositions;
    private int positionId;
}
