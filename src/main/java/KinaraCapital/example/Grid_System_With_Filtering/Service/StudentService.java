package KinaraCapital.example.Grid_System_With_Filtering.Service;

import KinaraCapital.example.Grid_System_With_Filtering.Model.Student;
import KinaraCapital.example.Grid_System_With_Filtering.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> getStudents(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return studentRepository.findAll(pageable);
    }

    public Page<Student> filterStudents(String column, String value, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Student> filteredStudents;
        switch (column) {
            case "id":
                filteredStudents = studentRepository.findByIdWithPagination(Long.valueOf(value), pageable);
                break;
            case "name":
                filteredStudents = studentRepository.findByName(value, pageable);
                break;
            case "totalMarks":
                filteredStudents = studentRepository.findByTotalMarks(Integer.valueOf(value), pageable);
                break;
            default:
                filteredStudents = Page.empty();
        }
        return filteredStudents;
    }

        public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
