package lab03.JPA.ENTITY;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent")
    private Long idStudent;
    private String name;
    private String registerNumber;
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "Session_Student",
            joinColumns = @JoinColumn(name = "student_id" , referencedColumnName = "idStudent"),
            inverseJoinColumns = @JoinColumn(name = "session_id",referencedColumnName = "sessionId")
    )
    private final List<Session> sessions = new ArrayList<>();

    public Student(Long id_student, String name, String register_number) {
        this.idStudent = id_student;
        this.name = name;
        this.registerNumber = register_number;
    }
    public Student(Long id_student, String name, String register_number,Session session) {
        this.idStudent = id_student;
        this.name = name;
        this.registerNumber = register_number;
        this.sessions.add(session);
    }

    public void addSession(Session session){
        this.sessions.add(session);
    }


}
