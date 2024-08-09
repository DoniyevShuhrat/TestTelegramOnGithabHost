package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        System.out.println("Hello world!");
        System.out.println("Start: " + LocalDateTime.now());
        String textMessage = LocalDateTime.now().toString();
        URI uriSendMessage = new URI("https://api.telegram.org/bot5536525742:AAF3dBOzXtOXu9eDfRGjFy9HPcifQ1O3sfA/sendMessage?chat_id=696175452&text=" + textMessage);
        //URI uriPostman_echo = new URI("https://postman-echo.com/get");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriSendMessage)
                //.uri(new URI(uriSendMessage))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
}