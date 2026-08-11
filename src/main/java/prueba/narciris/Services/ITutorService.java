package prueba.narciris.Services;

import prueba.narciris.DTOs.CreateTutorRequestDto;
import prueba.narciris.DTOs.TutorResponseDTO;

import java.util.List;

public interface ITutorService {

    List<TutorResponseDTO> all();
    TutorResponseDTO create(CreateTutorRequestDto createRequest);
    TutorResponseDTO findById (Long id);
    TutorResponseDTO update(Long id, CreateTutorRequestDto tutorRequest);
    TutorResponseDTO delete(Long id);
}
