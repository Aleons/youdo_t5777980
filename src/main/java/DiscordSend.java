import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DiscordSend {

    private static Map<String, ArrayList> listChannelInGroup;
    private static ArrayList<String> discords;

    public static void setDiscords(String listChannelInGroup) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            DiscordSend.listChannelInGroup = mapper.readValue(listChannelInGroup, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendMessage(String groupName, String message){
        if(!message.equals("null")) {
            discords = listChannelInGroup.get(groupName);
            for (int i = 0; i < discords.size(); i++) {
                DiscordsThread discordsThread = new DiscordsThread(discords.get(i), message);
                discordsThread.start();
                try {
                    discordsThread.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
