package prueba.narciris.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.narciris.Models.Tutor;

public interface ITutorRepository extends JpaRepository<Tutor, Long> {
}
