package spring.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "profile_pic")
    private String profilePic;

    @OneToMany(mappedBy="employee")
    private List<Skill> skills;

    @OneToMany(mappedBy = "employee")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "employee")
    private List<Language> languages;

    @OneToMany(mappedBy = "employee")
    private List<School> schools;
}
