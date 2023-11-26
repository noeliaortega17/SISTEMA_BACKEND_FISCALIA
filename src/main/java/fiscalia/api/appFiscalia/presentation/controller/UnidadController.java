package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import fiscalia.api.appFiscalia.domain.service.interfaces.PerfilService;
import fiscalia.api.appFiscalia.domain.service.interfaces.UnidadService;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UnidadDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/unidad")
public class UnidadController {

  private final UnidadService unidadService;

  @GetMapping
  public ResponseEntity<List<Unidad>> getAll() {
    List<Unidad> unidades = unidadService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(unidades);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Unidad> getById(@PathVariable Integer id) {
    Unidad unidadFound = unidadService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(unidadFound);
  }

  @PostMapping
  public ResponseEntity<Unidad> create(@RequestBody UnidadDto unidadDto) {
    Unidad unidadSaved = unidadService.create(unidadDto);
    return ResponseEntity.status(HttpStatus.OK).body(unidadSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Unidad> update(@PathVariable Integer id, @RequestBody UnidadDto unidadDto) {
    Unidad unidadUpdated = unidadService.update(id, unidadDto);
    return ResponseEntity.status(HttpStatus.OK).body(unidadUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    unidadService.delete(id);
    return ResponseEntity.ok().build();
  }

}