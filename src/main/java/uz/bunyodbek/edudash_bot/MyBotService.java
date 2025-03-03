package uz.bunyodbek.edudash_bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MyBotService {
    public SendMessage start(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Assalomu aleykum EDUDASH ning Telegramm Bot ga Xush kelibsiz!!!");
        return sendMessage;
    }
    public SendMessage shareContect(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Registratsiya qilish uchun  Kontaktingizni yuboring");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Share contect");
        button.setRequestContact(true);
        row.add(button);
        rows.add(row);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
    public SendMessage baho(Long chatId) {
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
