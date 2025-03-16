package uz.bunyodbek.edudash_bot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.edudash_bot.dto.StudentDto;
import uz.bunyodbek.edudash_bot.model.Result;
import uz.bunyodbek.edudash_bot.model.Student;
import uz.bunyodbek.edudash_bot.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody StudentDto studentDto){
        return studentService.create(studentDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody StudentDto studentDto){
        return studentService.update(id, studentDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return studentService.delete(id);
    }

}
