package lab03.JPA.Repository;

import lab03.JPA.ENTITY.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProfessor extends JpaRepository<Professor,Long> {
}
