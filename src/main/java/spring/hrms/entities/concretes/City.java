package spring.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
