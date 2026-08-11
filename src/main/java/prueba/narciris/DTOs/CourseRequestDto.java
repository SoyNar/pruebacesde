package prueba.narciris.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CourseRequestDto(@NotBlank(message = "El nombre del curso es obligatorio")
                               String name,

                               @NotBlank(message = "La descripción es obligatoria")
                               String description,

                               @NotNull(message = "La duración en semanas es obligatoria")
                               @Positive(message = "La duración debe ser mayor a cero")
                               Integer durationWeeks,

                               @NotNull(message = "El precio es obligatorio")
                               @Positive(message = "El precio debe ser mayor a cero")
                               BigDecimal price,

                               @NotNull(message = "La fecha de inicio es obligatoria")
                               LocalDateTime startDate,

                               @NotNull(message = "El ID del tutor es obligatorio")
                               Long tutorId) {
}
