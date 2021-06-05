package spring.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotNull
    @Column(name = "department")
    private String department;

    @NotNull
    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @NotNull
    @Column(name = "user_id")
    private int userId;
}
