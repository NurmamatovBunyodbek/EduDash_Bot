package uz.bunyodbek.edudash_bot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String grade;
}
