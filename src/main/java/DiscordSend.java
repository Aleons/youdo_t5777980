import java.util.ArrayList;

public class DiscordSend {

    private static ArrayList<String> discords = new ArrayList<String>();

    public static void setDiscords(String discords) {
        String url = "https://discordapp.com/api/webhooks/";
        String[] groups = discords.split(", ");
        for (String s:groups){
            DiscordSend.discords.add(url+s);
        }
    }

    public static void sendMessage(String message){
        if(!message.equals("null")) {
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
