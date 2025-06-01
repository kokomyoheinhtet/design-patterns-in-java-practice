package kkmhh.java.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonPlaceHolderClient {
    public static void main(String[] args) {
        JsonPlaceHolderClient jsonPlaceHolderClient = new JsonPlaceHolderClient();
        System.out.println("Hello world!");
        jsonPlaceHolderClient.getStatus();
    }

    public void getStatus() {

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}