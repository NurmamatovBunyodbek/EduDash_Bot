package uz.bunyodbek.edudash_bot.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.edudash_bot.model.Student;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    static Optional<Student> findById(Long studentId) {

        return Optional.empty();
    }
        boolean existsById (Integer id);




}
