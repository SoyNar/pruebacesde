package prueba.narciris.DTOs;

import prueba.narciris.Models.Course;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CoursesResponseDTo(Long id,
                                 String name,
                                 String description,
                                 Integer durationWeeks,
                                 BigDecimal price,
                                 LocalDateTime startDate,
                                 TutorResponseDTO tutor)
{

    public static CoursesResponseDTo fromEntity(Course course) {
        if (course == null) {
            return null;
        }

        TutorResponseDTO tutorDto = null;
        if (course.getTutor() != null) {
            tutorDto = new TutorResponseDTO(
                    course.getTutor().getId(),
                    course.getTutor().getName(),
                    course.getTutor().getDocument(),
                    course.getTutor().getEmail()
            );
        }

        return new CoursesResponseDTo(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getDurationWeeks(),
                course.getPrice(),
                course.getStartDate(),
                tutorDto
        );
    }
}
