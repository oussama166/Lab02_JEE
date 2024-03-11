package lab03.JPA.Repository;

import lab03.JPA.ENTITY.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySession extends JpaRepository<Session,Long> {
}
