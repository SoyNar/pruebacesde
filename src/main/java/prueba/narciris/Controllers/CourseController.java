package prueba.narciris.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.narciris.DTOs.CourseRequestDto;
import prueba.narciris.DTOs.CoursesResponseDTo;
import prueba.narciris.Services.ICourseSevice;

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


}
