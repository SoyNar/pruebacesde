package prueba.narciris.Services;

import org.springframework.stereotype.Service;
import prueba.narciris.DTOs.CourseRequestDto;
import prueba.narciris.DTOs.CoursesResponseDTo;
import prueba.narciris.DTOs.TutorResponseDTO;
import prueba.narciris.Models.Course;
import prueba.narciris.Models.Tutor;
import prueba.narciris.Repositories.ICourseRepository;
import prueba.narciris.Repositories.ITutorRepository;

import java.util.List;
import java.util.Optional;


 @Service
public class CourseServiceImpl implements ICourseSevice{


    private final ICourseRepository courseRepository;
    private final ITutorRepository tutorRepository;

    public CourseServiceImpl( ICourseRepository courseRepository, ITutorRepository tutorRepository){
        this.courseRepository = courseRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public List<CoursesResponseDTo> allCourses() {
        return courseRepository.findAll().stream().map(CoursesResponseDTo::fromEntity).toList();
    }

    @Override
    public Optional<CoursesResponseDTo> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<CoursesResponseDTo> findById(Long id) {
        return courseRepository.findById(id)
                .map(CoursesResponseDTo::fromEntity);
    }

    @Override
    public CoursesResponseDTo create(CourseRequestDto requestDto) {
        Tutor tutor = tutorRepository.findById(requestDto.tutorId())
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado con ID: " + requestDto.tutorId()));

        Course course = new Course();
        course.setName(requestDto.name());
        course.setDescription(requestDto.description());
        course.setDurationWeeks(requestDto.durationWeeks());
        course.setPrice(requestDto.price());
        course.setStartDate(requestDto.startDate());
        course.setTutor(tutor);

        Course savedCourse = courseRepository.save(course);

        return CoursesResponseDTo.fromEntity(savedCourse);
    }

    @Override
    public CoursesResponseDTo update(Long id,CourseRequestDto requestDto) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));

        Tutor tutor = tutorRepository.findById(requestDto.tutorId())
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado con ID: " + requestDto.tutorId()));

        existingCourse.setName(requestDto.name());
        existingCourse.setDescription(requestDto.description());
        existingCourse.setDurationWeeks(requestDto.durationWeeks());
        existingCourse.setPrice(requestDto.price());
        existingCourse.setStartDate(requestDto.startDate());
        existingCourse.setTutor(tutor);

        Course updatedCourse = courseRepository.save(existingCourse);

        return CoursesResponseDTo.fromEntity(updatedCourse);
    }

    @Override
    public CoursesResponseDTo delete(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        courseRepository.delete(course);
        return CoursesResponseDTo.fromEntity(course);
    }
}
