package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.RegistroObjecion;
import fiscalia.api.appFiscalia.domain.service.interfaces.RegistroObjecionService;
import fiscalia.api.appFiscalia.presentation.request.dto.RegistroObjecionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/registroobjecion")
public class RegistroObjecionController {

  private final RegistroObjecionService registroObjecionService;

  @GetMapping
  public ResponseEntity<List<RegistroObjecion>> getAll() {
    List<RegistroObjecion> registroObjeciones = registroObjecionService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(registroObjeciones);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RegistroObjecion> getById(@PathVariable Integer id) {
    RegistroObjecion registroObjecionFound = registroObjecionService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(registroObjecionFound);
  }

  @PostMapping
  public ResponseEntity<RegistroObjecion> create(@RequestBody RegistroObjecionDto registroObjecionDto) {
    RegistroObjecion registroObjecionSaved = registroObjecionService.create(registroObjecionDto);
    return ResponseEntity.status(HttpStatus.OK).body(registroObjecionSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<RegistroObjecion> update(@PathVariable Integer id, @RequestBody RegistroObjecionDto registroObjecionDto) {
    RegistroObjecion registroObjecionUpdated = registroObjecionService.update(id, registroObjecionDto);
    return ResponseEntity.status(HttpStatus.OK).body(registroObjecionUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    registroObjecionService.delete(id);
    return ResponseEntity.ok().build();
  }

}