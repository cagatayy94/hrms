package spring.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
public class Employer {

    @Id
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "web_site")
    private String web_site;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "employer_approved")
    private boolean employerApproved;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
