package lab03.JPA.Repository;

import lab03.JPA.ENTITY.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<Student,Long> {
}
