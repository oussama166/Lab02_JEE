package lab03.JPA.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sessionId")
    private Long sessionId;
    private Date date;
    private Date hStart;
    private Date hEnd;
    @ManyToMany(mappedBy = "sessions" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    final private List<Student> students = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seesion_lesson")
    private Lessons lesson;

    public Session(Long session_id, Date date, Date h_start, Date h_end, Lessons lesson) {
        this.sessionId = session_id;
        this.date = date;
        this.hStart = h_start;
        this.hEnd = h_end;
        this.lesson = lesson;
    }

    public void addStudent(Student st){
        students.add(st);
    }

}
