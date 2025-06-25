package es.ufv.dis.back.practica2.Back;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TurismoService {
    private final TurismoRepository repo;

    public TurismoService(TurismoRepository repo) {
        this.repo = repo;
    }

    public List<TurismoComunidad> getAll() {
        return repo.findAll();
    }

    public TurismoComunidad getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No existe turismo con id=" + id));
    }

    public TurismoComunidad create(TurismoComunidad t) {
        return repo.create(t);
    }

    public TurismoComunidad update(String id, TurismoComunidad t) {
        return repo.update(id, t);
    }

    public void delete(String id) {
        repo.delete(id);
    }

    public List<TurismoComunidad> filterByPeriodo(String periodo) {
        return repo.findByPeriodo(periodo);
    }
}

