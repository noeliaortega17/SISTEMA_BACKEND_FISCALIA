package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Delito;
import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import fiscalia.api.appFiscalia.domain.service.interfaces.DelitoService;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioInstructivoService;
import fiscalia.api.appFiscalia.presentation.request.dto.DelitoDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/delito")
public class DelitoController {

  private final DelitoService delitoService;

  @GetMapping
  public ResponseEntity<List<Delito>> getAll() {
    List<Delito> delitos = delitoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(delitos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Delito> getById(@PathVariable Integer id) {
    Delito delitoFound = delitoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(delitoFound);
  }

  @PostMapping
  public ResponseEntity<Delito> create(@RequestBody DelitoDto delitoDto) {
    Delito delitoSaved = delitoService.create(delitoDto);
    return ResponseEntity.status(HttpStatus.OK).body(delitoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Delito> update(@PathVariable Integer id, @RequestBody DelitoDto delitoDto) {
    Delito delitoUpdated = delitoService.update(id, delitoDto);
    return ResponseEntity.status(HttpStatus.OK).body(delitoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    delitoService.delete(id);
    return ResponseEntity.ok().build();
  }

}