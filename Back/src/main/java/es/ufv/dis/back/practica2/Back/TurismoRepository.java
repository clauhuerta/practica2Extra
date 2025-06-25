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
import java.util.stream.Collectors;

@Repository
public class TurismoRepository {
    private static final Path DATA_FILE = Path.of("TurismoComunidades.json");
    private final Gson gson = new Gson();
    private List<TurismoComunidad> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            String json = Files.readString(DATA_FILE);
            Type listType = new TypeToken<List<TurismoComunidad>>(){}.getType();
            items = gson.fromJson(json, listType);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer TurismoComunidades.json", e);
        }
    }

    private void persist() {
        try {
            Files.writeString(DATA_FILE, gson.toJson(items));
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir TurismoComunidades.json", e);
        }
    }

    public List<TurismoComunidad> findAll() {
        return Collections.unmodifiableList(items);
    }

    public Optional<TurismoComunidad> findById(String id) {
        return items.stream().filter(t -> t.get_id().equals(id)).findFirst();
    }

    public TurismoComunidad create(TurismoComunidad t) {
        t.set_id(UUID.randomUUID().toString());
        items.add(t);
        persist();
        return t;
    }

    public TurismoComunidad update(String id, TurismoComunidad nuevo) {
        TurismoComunidad orig = findById(id)
                .orElseThrow(() -> new NoSuchElementException("No existe id=" + id));
        orig.setPeriodo(nuevo.getPeriodo());
        orig.setTotal(nuevo.getTotal());
        orig.setProvinciaOrigen(nuevo.getProvinciaOrigen());
        orig.setComunidadOrigen(nuevo.getComunidadOrigen());
        orig.setComunidadDestino(nuevo.getComunidadDestino());
        orig.setProvinciaDestino(nuevo.getProvinciaDestino());
        persist();
        return orig;
    }

    public void delete(String id) {
        items = items.stream()
                .filter(t -> !t.get_id().equals(id))
                .collect(Collectors.toList());
        persist();
    }

    public List<TurismoComunidad> findByPeriodo(String periodo) {
        return items.stream()
                .filter(t -> t.getPeriodo().equals(periodo))
                .collect(Collectors.toList());
    }
}
