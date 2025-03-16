package uz.bunyodbek.edudash_bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.edudash_bot.model.Subject;

import javax.naming.Name;
import java.util.Optional;

public interface SubjectRepo extends JpaRepository<Subject, Name> {

    boolean existsByName(String name);


    Optional<Subject> findById(Integer id);

    void deleteById(Integer id);

}
