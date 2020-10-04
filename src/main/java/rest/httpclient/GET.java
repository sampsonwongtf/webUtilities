package rest.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;

import static org.apache.http.HttpStatus.*;
/**
 * Performs a GET request for the given input
 */
public class GET {

    public void rest_GET(){
        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet get = new HttpGet("http://httpbin.org/get");
            ResponseHandler<String> rspHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= SC_OK && status < SC_MULTIPLE_CHOICES) {
                    HttpEntity ent = response.getEntity();
                    return ent != null ? EntityUtils.toString(ent) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }

            };
            String responseBody = httpclient.execute(get, rspHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
