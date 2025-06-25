package org.vaadin.example;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.*;
import java.util.List;

@Service
public class TurismoClient {
    private static final String BASE = "http://localhost:8080/api/turismos";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    private final Type listType = new TypeToken<List<TurismoComunidad>>(){}.getType();

    public List<TurismoComunidad> fetchAll() throws IOException, InterruptedException {
        String body = client.send(
                HttpRequest.newBuilder(URI.create(BASE)).GET().build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        return gson.fromJson(body, listType);
    }

    // métodos fetchById, create, update, delete y filterByFecha idénticos al ejemplo anterior
}

