package spring.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
