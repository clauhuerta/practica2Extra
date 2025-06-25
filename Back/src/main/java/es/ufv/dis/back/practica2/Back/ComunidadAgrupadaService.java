package es.ufv.dis.back.practica2.Back;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComunidadAgrupadaService {
    private final ComunidadAgrupadaRepository repo;

    public ComunidadAgrupadaService(ComunidadAgrupadaRepository repo) {
        this.repo = repo;
    }

    public List<String> getAllCodigos() {
        return repo.findAllCodigos();
    }

    public ComunidadAgrupada getByCodigo(String codigo) {
        return repo.findByCodigo(codigo);
    }
}

