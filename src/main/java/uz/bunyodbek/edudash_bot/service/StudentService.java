package uz.bunyodbek.edudash_bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.edudash_bot.dto.StudentDto;
import uz.bunyodbek.edudash_bot.model.Result;
import uz.bunyodbek.edudash_bot.model.Student;
import uz.bunyodbek.edudash_bot.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    //get all students
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    //get by id
    public Student getById(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        return studentOptional.get();
    }

    //create
    public Result create(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setGrade(studentDto.getGrade());
        studentRepo.save(student);
        return new Result(true, "Student Created");
    }

    //update
    public Result update(Integer id, StudentDto studentDto) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstname(studentDto.getFirstname());
            student.setLastname(studentDto.getLastname());
            student.setEmail(studentDto.getEmail());
            student.setPassword(studentDto.getPassword());
            student.setGrade(studentDto.getGrade());
            studentRepo.save(student);
            return new Result(true, "Student Updated");
        }
        return new Result(false, "Student Not Found");
    }

    //Delete
    public Result delete(Integer id) {
        studentRepo.deleteById(id);
        return new Result(true, "Student deleted");
    }
}