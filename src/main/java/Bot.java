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
        String groupName=update.getMessage().getChat().getTitle();
        String message = update.getMessage().getText();
        DiscordSend.sendMessage(groupName, message);
    }



    public String getBotUsername() {
        return name;
    }

    public String getBotToken() {
        return token;
    }


}
