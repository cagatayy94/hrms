package spring.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee{

    @Id
    @Column(name="user_id")
    private int user_id;

    @Column(name = "identification_number")
    private String identification_number;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private String birthday;
}
