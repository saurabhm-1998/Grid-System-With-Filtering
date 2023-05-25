package KinaraCapital.example.Grid_System_With_Filtering.Controller;

import KinaraCapital.example.Grid_System_With_Filtering.Model.Student;
import KinaraCapital.example.Grid_System_With_Filtering.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Page<Student>> getStudents(
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize) {
        Page<Student> students = studentService.getStudents(page, pageSize);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/filter")
    public ResponseEntity<Page<Student>> filterStudents(
            @RequestParam("column") String column,
            @RequestParam("value") String value,
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize) {
        Page<Student> filteredStudents = studentService.filterStudents(column, value, page, pageSize);
        return ResponseEntity.ok(filteredStudents);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);

    }
}