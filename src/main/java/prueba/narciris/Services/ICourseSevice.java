package prueba.narciris.Services;

import prueba.narciris.DTOs.CourseRequestDto;
import prueba.narciris.DTOs.CoursesResponseDTo;

import java.util.List;
import java.util.Optional;

public interface ICourseSevice {

    List<CoursesResponseDTo> allCourses();
    Optional<CoursesResponseDTo> findByName(String name);
    Optional<CoursesResponseDTo> findById(Long id);
    CoursesResponseDTo create(CourseRequestDto requestDto);
    CoursesResponseDTo update(Long id,CourseRequestDto responseDTo);
    CoursesResponseDTo delete (Long id);
}
