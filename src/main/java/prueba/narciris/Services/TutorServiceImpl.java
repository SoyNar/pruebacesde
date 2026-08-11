package prueba.narciris.Services;

import org.springframework.stereotype.Service;
import prueba.narciris.DTOs.CreateTutorRequestDto;
import prueba.narciris.DTOs.TutorResponseDTO;
import prueba.narciris.Models.Tutor;
import prueba.narciris.Repositories.ITutorRepository;

import java.util.List;

@Service
public class TutorServiceImpl implements ITutorService{

    private final ITutorRepository tutorRepo;

    public TutorServiceImpl(ITutorRepository tutorRepo)
    {
        this.tutorRepo = tutorRepo;
    }

    @Override
    public List<TutorResponseDTO> all() {
        return tutorRepo.findAll().stream()
                .map(tutor -> new TutorResponseDTO(
                        tutor.getId(),
                        tutor.getName(),
                        tutor.getDocument(),
                        tutor.getEmail()
                ))
                .toList();
    }

    @Override
    public TutorResponseDTO create(CreateTutorRequestDto createRequest)
    {

        Tutor tutor = new Tutor();
        tutor.setName(createRequest.name());
        tutor.setDocument(createRequest.document());
        tutor.setEmail(createRequest.email());

        Tutor savedTutor = tutorRepo.save(tutor);

        return new TutorResponseDTO(
                savedTutor.getId(),
                savedTutor.getName(),
                savedTutor.getDocument(),
                savedTutor.getEmail()
        );
    }

    @Override
    public TutorResponseDTO findById(Long id) {
        Tutor tutor = tutorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado con ID: " + id));

        return new TutorResponseDTO(
                tutor.getId(),
                tutor.getName(),
                tutor.getDocument(),
                tutor.getEmail()
        );
    }

    @Override
    public TutorResponseDTO update(Long id, CreateTutorRequestDto tutorRequest) {
        Tutor existingTutor = tutorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado con ID: " + id));

        existingTutor.setName(tutorRequest.name());
        existingTutor.setDocument(tutorRequest.document());
        existingTutor.setEmail(tutorRequest.email());

        Tutor updatedTutor = tutorRepo.save(existingTutor);

        return new TutorResponseDTO(
                updatedTutor.getId(),
                updatedTutor.getName(),
                updatedTutor.getDocument(),
                updatedTutor.getEmail()
        );
    }

    @Override
    public TutorResponseDTO delete(Long id) {
        Tutor tutor = tutorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado con ID: " + id));
        tutorRepo.delete(tutor);
        return new TutorResponseDTO(
                tutor.getId(),
                tutor.getName(),
                tutor.getDocument(),
                tutor.getEmail()
        );
    }
}
