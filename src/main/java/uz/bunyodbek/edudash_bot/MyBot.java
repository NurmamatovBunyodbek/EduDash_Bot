package uz.bunyodbek.edudash_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import uz.bunyodbek.edudash_bot.Controller.StudentController;

@Component
public class MyBot extends TelegramLongPollingBot {
    private MyBotService myBotService = new MyBotService();
    private StudentController studentController = new StudentController();
    @Autowired
    InfoRepo infoRepo;
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            Long chatId = update.getMessage().getChatId();
            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();
            String text = update.getMessage().getText();

            Info info = new Info(chatId, firstName, lastName, text);
            infoRepo.save(info);
            if (text.equals("/start")){
                try {
                    execute(myBotService.start(chatId));
                    execute(myBotService.shareContact(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("Share contact")){
                try {
                    execute(myBotService.requestStudentId(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            }
        }



    @Override
    public String getBotUsername() {
        return "@IlyosjonProject_bot:";
    }

    public MyBot (TelegramBotsApi telegramBotsApi) throws TelegramApiException {
        super("7657833917:AAHpOBHTwJMPZDlDEz14A1vAIMdWluyq7wM");
        telegramBotsApi.registerBot(this);

    }
}

