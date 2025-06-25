package es.ufv.dis.back.practica2.Back;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/turismos")
public class TurismoController {
    private final TurismoService service;

    public TurismoController(TurismoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TurismoComunidad> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TurismoComunidad one(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurismoComunidad create(@RequestBody TurismoComunidad t) {
        return service.create(t);
    }

    @PutMapping("/{id}")
    public TurismoComunidad update(@PathVariable String id, @RequestBody TurismoComunidad t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/filter")
    public List<TurismoComunidad> filterByFecha(@RequestParam("periodo") String periodo) {
        return service.filterByPeriodo(periodo);
    }
}
