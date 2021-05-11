package spring.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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
