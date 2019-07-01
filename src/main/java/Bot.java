import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class Bot extends TelegramLongPollingBot {

    private String token;
    private String name;

    public Bot(String token, String name){
        this.token = token;
        this.name = name;

    }


    public void onUpdateReceived(Update update) {
        DiscordSend.sendMessage(update.getMessage().getText());
    }



    public String getBotUsername() {
        return name;
    }

    public String getBotToken() {
        return token;
    }


}
