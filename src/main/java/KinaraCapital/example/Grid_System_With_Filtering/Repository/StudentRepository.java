package KinaraCapital.example.Grid_System_With_Filtering.Repository;

import KinaraCapital.example.Grid_System_With_Filtering.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByName(String name, Pageable pageable);

    Page<Student> findByTotalMarks(int totalMarks, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Page<Student> findByIdWithPagination(@Param("id") Long id, Pageable pageable);


    Student save(Student student);

}
