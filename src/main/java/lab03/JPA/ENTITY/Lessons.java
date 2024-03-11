package lab03.JPA.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLesson;
    private String title;
    private String description;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "lesson" , fetch = FetchType.EAGER)
    private Set<Session> session;
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Lessons(long idLesson, String title, String description) {
        this.idLesson = idLesson;
        this.title = title;
        this.description = description;
    }

    public Lessons(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Lessons(String title, String description, Professor professor) {
        this.title = title;
        this.description = description;
        this.professor = professor;
    }

}
