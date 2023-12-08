package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import fiscalia.api.appFiscalia.domain.service.interfaces.TipoDelitoService;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoDelitoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/tipoDelito")
public class TipoDelitoController {

  private final TipoDelitoService tipoDelitoService;

  @GetMapping
  public ResponseEntity<List<TipoDelito>> getAll() {
    List<TipoDelito> tipoDelitos = tipoDelitoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(tipoDelitos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TipoDelito> getById(@PathVariable Integer id) {
    TipoDelito tipoDelitoFound = tipoDelitoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(tipoDelitoFound);
  }

  @PostMapping
  public ResponseEntity<TipoDelito> create(@RequestBody TipoDelitoDto tipoDelitoDto) {
    TipoDelito tipoDelitoSaved = tipoDelitoService.create(tipoDelitoDto);
    return ResponseEntity.status(HttpStatus.OK).body(tipoDelitoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<TipoDelito> update(@PathVariable Integer id, @RequestBody TipoDelitoDto tipoDelitoDto) {
    TipoDelito tipoDelitoFound = tipoDelitoService.update(id, tipoDelitoDto);
    return ResponseEntity.status(HttpStatus.OK).body(tipoDelitoFound);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    tipoDelitoService.delete(id);
    return ResponseEntity.ok().build();
  }

}