package prueba.narciris.Repositories;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import prueba.narciris.Models.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
