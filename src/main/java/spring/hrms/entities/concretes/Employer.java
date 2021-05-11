package spring.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
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
}
