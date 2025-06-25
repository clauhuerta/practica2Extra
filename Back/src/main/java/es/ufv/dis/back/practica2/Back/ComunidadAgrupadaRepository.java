package es.ufv.dis.back.practica2.Back;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Repository
public class ComunidadAgrupadaRepository {
    private static final Path DATA_FILE = Path.of("Comunidades_agrupadas.json");
    private final Gson gson = new Gson();
    private Map<String, ComunidadAgrupada> map = new TreeMap<>();

    @PostConstruct
    public void init() {
        try {
            String json = Files.readString(DATA_FILE);
            Type listType = new TypeToken<List<ComunidadAgrupada>>(){}.getType();
            List<ComunidadAgrupada> list = gson.fromJson(json, listType);
            list.forEach(ca -> map.put(ca.getCodigoComunidad(), ca));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer Comunidades_agrupadas.json", e);
        }
    }

    public List<String> findAllCodigos() {
        return new ArrayList<>(map.keySet());
    }

    public ComunidadAgrupada findByCodigo(String codigo) {
        ComunidadAgrupada ca = map.get(codigo);
        if (ca==null) throw new NoSuchElementException("No existe comunidad " + codigo);
        return ca;
    }
}
