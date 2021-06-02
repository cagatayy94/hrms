package spring.hrms.entities.concretes;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "job_board")
public class JobBoard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name="position_id")
    //private int positionId;

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name="description")
    private String description;

    //@Column(name="city_id")
    //private int cityId;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name = "open_positions")
    private int openPositions;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "active")
    private boolean active;

    //@Column(name = "employer_id")
    //private int employerId;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;
}
