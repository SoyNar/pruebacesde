package prueba.narciris.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateTutorRequestDto(
        @NotBlank(message = "El nombre del tutor es obligatorio")
        String name,

        @NotBlank(message = "El documento es obligatorio")
        String document,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Debe proporcionar un formato de correo válido")
        String email
) {
}
