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
public class ComunidadClient {
    private static final String BASE = "http://localhost:8080/api/comunidades";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    private final Type codType = new TypeToken<List<String>>(){}.getType();

    public List<String> fetchCodigos() throws IOException, InterruptedException {
        String body = client.send(
                HttpRequest.newBuilder(URI.create(BASE)).GET().build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        return gson.fromJson(body, codType);
    }

    // método fetchByCodigo idéntico al ejemplo anterior
}

