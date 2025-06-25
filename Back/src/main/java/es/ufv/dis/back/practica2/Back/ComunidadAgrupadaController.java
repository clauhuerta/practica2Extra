package es.ufv.dis.back.practica2.Back;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadAgrupadaController {
    private final ComunidadAgrupadaService service;

    public ComunidadAgrupadaController(ComunidadAgrupadaService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> allCodigos() {
        return service.getAllCodigos();
    }

    @GetMapping("/{codigo}")
    public ComunidadAgrupada byCodigo(@PathVariable String codigo) {
        return service.getByCodigo(codigo);
    }
}

