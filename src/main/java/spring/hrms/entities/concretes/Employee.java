package spring.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee extends User{

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private String birthday;
}
