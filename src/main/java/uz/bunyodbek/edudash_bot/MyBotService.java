package uz.bunyodbek.edudash_bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.bunyodbek.edudash_bot.model.Student;
import uz.bunyodbek.edudash_bot.repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyBotService {
    public SendMessage start(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Assalomu aleykum EDUDASH ning Telegramm Bot ga Xush kelibsiz!!!");
        return sendMessage;
    }
    public SendMessage shareContact(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Registratsiya qilish uchun  Kontaktingizni yuboring");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Share contact");
        button.setRequestContact(true);
        row.add(button);
        rows.add(row);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
    public SendMessage requestStudentId(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Farzandingizning ID sini kiriting:");

        return message;
    }
    public SendMessage getStudentInfo(Long chatId, Long studentId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        Optional<Student> studentOptional = StudentRepo.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            message.setText("Farzandingiz: " + student.getFirstname() + " " + student.getLastname());
            message.setReplyMarkup(getClass(reply(Long ,chatId)); // Tugmalar qo‘shiladi <-- bu yerga qarang ustoz
        } else {
            message.setText("Bunday ID topilmadi, qaytadan kiriting.");
        }

        return message;
    }
    public SendMessage reply(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Tanlang!!!");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Kunlik");
        row.add(button);
        rowList.add(row);

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Haftalik");
        row.add(button1);
        rowList.add(row);

        KeyboardButton button2 = new KeyboardButton();
        KeyboardRow row1 = new KeyboardRow();
        button2.setText("Oylik");
        row1.add(button2);
        rowList.add(row1);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Davomat");
        row1.add(button3);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Aloqa");
        row2.add(button4);
        rowList.add(row2);

        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }





}
