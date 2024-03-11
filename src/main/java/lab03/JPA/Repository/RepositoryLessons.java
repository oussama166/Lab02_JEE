package lab03.JPA.Repository;

import lab03.JPA.ENTITY.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryLessons extends JpaRepository<Lessons,Long> {
}
