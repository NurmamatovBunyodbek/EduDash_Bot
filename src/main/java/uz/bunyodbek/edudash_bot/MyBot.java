package uz.bunyodbek.edudash_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static jdk.javadoc.internal.tool.Main.execute;

@Component
public class MyBot {
    private MyBotService myBotService = new MyBotService();

    @Autowired
    InfoRepo infoRepo;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();

            Info info = new Info(chatId, firstName, lastName);
            infoRepo.save(info);
            if (text.equals("/start")){
                try {
                    execute(myBotService.start(chatId));
                    execute(myBotService.shareContect(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (update.hasMessage() && update.getMessage().hasContact()) {
                Long chatId = update.getMessage().getChatId();


                Contact contact = update.getMessage().getContact();
                String phoneNumber = contact.getPhoneNumber();
                try {
                    execute(myBotService.shareContect(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
}
