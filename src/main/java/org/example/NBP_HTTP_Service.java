package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NBP_HTTP_Service {

    public NBP_Response getResponseFromNBPAndParse (String currency) throws IOException, URISyntaxException, InterruptedException {
        String query = "https://api.nbp.pl/api/exchangerates/rates/a/{currency}/?format=json".
            replace("{currency}", currency);
        URL nbpUrl = new URL(query);
        HttpRequest requestToNbp = HttpRequest.newBuilder(nbpUrl.toURI()).GET().build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> nbpJson = client.send(requestToNbp, HttpResponse.BodyHandlers.ofString());
        NBP_Response response;
        Gson gson = new Gson();
        response = gson.fromJson(nbpJson.body(), NBP_Response.class);
        return response;
    }

}

