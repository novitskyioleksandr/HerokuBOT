package com.github.goitproject.bot.service;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ClientService {
    private String previewJson;

    public <T> ArrayList<T> getCurrencyFromBank(String url, Type type) throws Exception {
        String json = getResponse(url).body();
        if (json.equals("{\"errorDescription\":\"Too many requests\"}")) {
           json = previewJson;
        }else {
            previewJson = json;
        }

        return new Gson().fromJson(json, type);
    }

    private HttpResponse<String> getResponse(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
