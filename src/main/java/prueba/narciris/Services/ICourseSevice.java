package prueba.narciris.Services;

import prueba.narciris.DTOs.CourseRequestDto;
import prueba.narciris.DTOs.CoursesResponseDTo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ICourseSevice {

    List<CoursesResponseDTo> allCourses();
    Optional<CoursesResponseDTo> findByName(String name);
    Optional<CoursesResponseDTo> findById(Long id);
    CoursesResponseDTo create(CourseRequestDto requestDto);
    CoursesResponseDTo update(Long id,CourseRequestDto responseDTo);
    CoursesResponseDTo delete (Long id);
    List<CoursesResponseDTo> filterCourses(String name, BigDecimal minPrice, Long tutorId);
}
