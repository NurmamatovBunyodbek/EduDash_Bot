package uz.bunyodbek.edudash_bot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.edudash_bot.dto.StudentDto;
import uz.bunyodbek.edudash_bot.dto.SubjectDto;
import uz.bunyodbek.edudash_bot.model.Result;
import uz.bunyodbek.edudash_bot.model.Student;
import uz.bunyodbek.edudash_bot.model.Subject;
import uz.bunyodbek.edudash_bot.repository.SubjectRepo;
import uz.bunyodbek.edudash_bot.service.StudentService;
import uz.bunyodbek.edudash_bot.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAll();
    }
    @GetMapping("/{id}")
    public Subject getById(@PathVariable Integer id){
        return subjectService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SubjectDto subjectDto){
        return subjectService.create(subjectDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SubjectDto subjectDto){
        return subjectService.update(id, subjectDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return subjectService.delete(id);
    }
}
