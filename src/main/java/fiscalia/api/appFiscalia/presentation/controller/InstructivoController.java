package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import fiscalia.api.appFiscalia.domain.service.interfaces.InstructivoService;
import fiscalia.api.appFiscalia.presentation.request.dto.InstructivoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/instructivo")
public class InstructivoController {

  private final InstructivoService instructivoService;

  @GetMapping
  public ResponseEntity<List<Instructivo>> getAll() {
    List<Instructivo> instructivos = instructivoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(instructivos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Instructivo> getById(@PathVariable Integer id) {
    Instructivo instructivoFound = instructivoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(instructivoFound);
  }

  @PostMapping
  public ResponseEntity<Instructivo> create(@RequestBody InstructivoDto instructivoDto) {
    Instructivo instructivoSaved = instructivoService.create(instructivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(instructivoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Instructivo> update(@PathVariable Integer id, @RequestBody InstructivoDto instructivoDto) {
    Instructivo instructivoUpdated = instructivoService.update(id, instructivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(instructivoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    instructivoService.delete(id);
    return ResponseEntity.ok().build();
  }

}