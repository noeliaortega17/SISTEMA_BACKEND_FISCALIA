package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Desarchivo;
import fiscalia.api.appFiscalia.domain.service.interfaces.DesarchivoService;
import fiscalia.api.appFiscalia.presentation.request.dto.DesarchivoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/desarchivo")
public class DesarchivoController {

  private final DesarchivoService desarchivoService;

  @GetMapping
  public ResponseEntity<List<Desarchivo>> getAll() {
    List<Desarchivo> desarchivos = desarchivoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(desarchivos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Desarchivo> getById(@PathVariable Integer id) {
    Desarchivo desarchivoFound = desarchivoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(desarchivoFound);
  }

  @PostMapping
  public ResponseEntity<Desarchivo> create(@RequestBody DesarchivoDto desarchivoDto) {
    Desarchivo desarchivoSaved = desarchivoService.create(desarchivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(desarchivoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Desarchivo> update(@PathVariable Integer id, @RequestBody DesarchivoDto desarchivoDto) {
    Desarchivo desarchivoUpdated = desarchivoService.update(id, desarchivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(desarchivoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    desarchivoService.delete(id);
    return ResponseEntity.ok().build();
  }

}