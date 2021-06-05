package spring.hrms.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobBoardListDto {
    private String employerName;
    private String positionName;
    private int openPositions;
    private Date createdAt;
    private Date dueDate;
}
