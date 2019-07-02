import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        String token;
        String name;
        String listChannelInGroup;
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            token = property.getProperty("botToken");
            name = property.getProperty("botName");
            listChannelInGroup = property.getProperty("listChannelInGroup");
            DiscordSend.setDiscords(listChannelInGroup);

        } catch (IOException e) {
            token = "error";
            name = "error";
        }

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {

            telegramBotsApi.registerBot(new Bot(token, name));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
