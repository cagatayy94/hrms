package spring.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "web_site")
    private String web_site;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "employer_approved")
    private boolean employerApproved;
}
