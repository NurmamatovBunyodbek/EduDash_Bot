package uz.bunyodbek.edudash_bot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity

public class Info {

    @Id
    private Long chatid;
    private String firstname;
    private String lastname;

    public Info(Long chatid, String firstname, String lastname) {
        this.chatid = chatid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Info() {
    }

    public Long getChatid() {
        return chatid;
    }

    public void setChatid(Long chatid) {
        this.chatid = chatid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Info{" +
                "chatid=" + chatid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
