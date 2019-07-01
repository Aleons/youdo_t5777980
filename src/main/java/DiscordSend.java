import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
        HttpClient httpClient = HttpClientBuilder.create().build();
        String json = "{\"content\":\""+message+"\"}";
        try {
            StringEntity params =new StringEntity(json, "UTF-8");
            HttpPost post = new HttpPost(discords.get(0));
            post.setEntity(params);
            post.setHeader("Accept-Encoding", "UTF-8");
            post.addHeader("content-type", "application/json;UTF-8");
            httpClient.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
