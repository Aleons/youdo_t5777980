import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DiscordsThread extends Thread {

    String chatUrl;
    String message;

    public DiscordsThread(String chatUrl, String message){
        this.chatUrl=chatUrl;
        this.message=message;
    }

    @Override
    public void run() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String json = "{\"content\":\""+message+"\"}";
        try {
            StringEntity params =new StringEntity(json, "UTF-8");
            HttpPost post = new HttpPost(chatUrl);
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
