package uz.bunyodbek.edudash_bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.edudash_bot.dto.SubjectDto;
import uz.bunyodbek.edudash_bot.model.Result;
import uz.bunyodbek.edudash_bot.model.Subject;
import uz.bunyodbek.edudash_bot.repository.SubjectRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepo subjectRepo;

    //get all subject
    public List<Subject> getAll() {
        return subjectRepo.findAll();
    }

    //get by id
    public Subject getById(Integer id) {
       Optional<Subject> subjectOptional = subjectRepo.findById(id);
       return subjectOptional.get();
    }

    //create
    public Result create(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subject.setDescription(subjectDto.getDescription());
        subjectRepo.save(subject);
        return new Result(true, "Subject Created");
    }

    //update
    public Result update(Integer id, SubjectDto subjectDto) {
        Optional<Subject> subjectOptional = subjectRepo.findById(id);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            subject.setName(subjectDto.getName());
            subject.setDescription(subjectDto.getDescription());
            subjectRepo.save(subject);
            return new Result(true, "Subject Updated");
        }
        return new Result(false, "Subject Not Found");
    }

    //Delete
    public Result delete(Integer id) {
        subjectRepo.deleteById(id);
        return new Result(true, "Subject deleted");
    }
}
