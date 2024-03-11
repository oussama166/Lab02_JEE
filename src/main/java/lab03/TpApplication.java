package lab03;

import lab03.JPA.ENTITY.Lessons;
import lab03.JPA.ENTITY.Professor;
import lab03.JPA.ENTITY.Session;
import lab03.JPA.ENTITY.Student;
import lab03.JPA.Repository.RepositoryLessons;
import lab03.JPA.Repository.RepositoryProfessor;
import lab03.JPA.Repository.RepositorySession;
import lab03.JPA.Repository.RepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TpApplication implements CommandLineRunner {

    @Autowired
    private RepositoryLessons repositoryLessons;
    @Autowired
    private RepositoryProfessor repositoryProfessor;
    @Autowired
    private RepositorySession repositorySession;
    @Autowired
    private RepositoryStudent repositoryStudent;

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Lessons lessons = new Lessons((long) 1, "SVT BAC", "20/20 in svt with warak");
        Professor professor = new Professor((long) 1, "Alwarak zakaria", new Date(2003, 1, 10));
        professor.setLesson(lessons);
        lessons.setProfessor(professor);

        repositoryProfessor.save(professor);
        repositoryLessons.save(lessons);

// Create a session
        Session session = new Session((long) 1, new Date(2012, 10, 26), new Date(2012, 11, 1), new Date(2012, 10, 30), lessons);

// Create students
        Student student1 = new Student((long) 1, "oussama ouardi", "EMSI20021006");
        Student student2 = new Student((long) 2, "issa habachi", "EMSI20020320");
        Student student3 = new Student((long) 3, "zakaria moulahid", "EMSI20001201");
        Student student4 = new Student((long) 4, "mandoubi abdelrahman", "EMSI20030304");

        session.addStudent(student1);
        session.addStudent(student2);
        session.addStudent(student3);
        session.addStudent(student4);
        student1.addSession(session);
        student2.addSession(session);
        student3.addSession(session);
        student4.addSession(session);

        repositorySession.save(session);
        repositoryStudent.save(student1);

    }
}
