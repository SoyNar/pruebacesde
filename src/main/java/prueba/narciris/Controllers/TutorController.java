package prueba.narciris.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.narciris.DTOs.CreateTutorRequestDto;
import prueba.narciris.DTOs.TutorResponseDTO;
import prueba.narciris.Services.ITutorService;

import java.util.List;

@RestController
@RequestMapping(path = "tutor")
public class TutorController {

    private final ITutorService tutorService;

    public TutorController(ITutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> getAllTutors() {
        return ResponseEntity.ok(tutorService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> getTutorById(@PathVariable Long id) {
        TutorResponseDTO tutor = tutorService.findById(id);
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<TutorResponseDTO> createTutor(@RequestBody @Valid CreateTutorRequestDto createRequest) {
        TutorResponseDTO createdTutor = tutorService.create(createRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> updateTutor(
            @PathVariable Long id,
            @RequestBody @Valid CreateTutorRequestDto tutorRequest
    ) {
        TutorResponseDTO updatedTutor = tutorService.update(id, tutorRequest);
        return ResponseEntity.ok(updatedTutor);
    }
}
