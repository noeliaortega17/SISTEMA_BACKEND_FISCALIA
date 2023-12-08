package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import fiscalia.api.appFiscalia.domain.service.interfaces.TipoObjecionService;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoObjecionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/tipoobjecion")
public class TipoobjecionController {

  private final TipoObjecionService tipoObjecionService;

  @GetMapping
  public ResponseEntity<List<TipoObjecion>> getAll() {
    List<TipoObjecion> tipoObjeciones = tipoObjecionService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(tipoObjeciones);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TipoObjecion> getById(@PathVariable Integer id) {
    TipoObjecion tipoObjecionFound = tipoObjecionService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(tipoObjecionFound);
  }

  @PostMapping
  public ResponseEntity<TipoObjecion> create(@RequestBody TipoObjecionDto tipoObjecionDto) {
    TipoObjecion tipoObjecionSaved = tipoObjecionService.create(tipoObjecionDto);
    return ResponseEntity.status(HttpStatus.OK).body(tipoObjecionSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<TipoObjecion> update(@PathVariable Integer id, @RequestBody TipoObjecionDto tipoObjecionDto) {
    TipoObjecion tipoObjecionUpdated = tipoObjecionService.update(id, tipoObjecionDto);
    return ResponseEntity.status(HttpStatus.OK).body(tipoObjecionUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    tipoObjecionService.delete(id);
    return ResponseEntity.ok().build();
  }

}