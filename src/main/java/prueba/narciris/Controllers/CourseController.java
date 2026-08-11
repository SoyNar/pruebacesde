package prueba.narciris.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.narciris.DTOs.CourseRequestDto;
import prueba.narciris.DTOs.CoursesResponseDTo;
import prueba.narciris.Services.ICourseSevice;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "courses")
public class CourseController {


    private final ICourseSevice courseSevice;

    public  CourseController(ICourseSevice courseSevice){
        this.courseSevice = courseSevice;
    }

    @GetMapping
    public ResponseEntity<List<CoursesResponseDTo>> all(){
        List<CoursesResponseDTo> responseDTo = this.courseSevice.allCourses();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTo);
    }

    @PostMapping("/create")
    public  ResponseEntity<CoursesResponseDTo> create(  @RequestBody CourseRequestDto requestDto)
    {
        CoursesResponseDTo responseDTo = this.courseSevice.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursesResponseDTo> getCourseById(@PathVariable Long id) {
        return courseSevice.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursesResponseDTo> updateCourse(
            @PathVariable Long id,
            @RequestBody @Valid CourseRequestDto requestDto
    ) {
        CoursesResponseDTo updated = courseSevice.update(id, requestDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CoursesResponseDTo> deleteCourse(@PathVariable Long id) {
        CoursesResponseDTo deleted = courseSevice.delete(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CoursesResponseDTo>> filterCourses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) Long tutorId) {

        return ResponseEntity.ok(courseSevice.filterCourses(name, minPrice, tutorId));
    }



}
