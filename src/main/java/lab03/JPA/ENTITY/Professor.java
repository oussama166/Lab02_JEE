package lab03.JPA.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

// @Author oussama ouardi
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;
    private String name;
    private Date dateAffect;
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "professor")
    @JoinColumn(name = "lesson_id")
    private Lessons lesson;

    public Professor(long idProfessor, String name, Date date_affect) {
        this.idProfessor = idProfessor;
        this.name = name;
        this.dateAffect = date_affect;
    }

    public Professor(String name, Date date_affect, Lessons lesson) {
        this.name = name;
        this.dateAffect = date_affect;
        this.lesson = lesson;
    }

}
