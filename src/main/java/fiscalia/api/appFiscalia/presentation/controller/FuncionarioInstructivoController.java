package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioInstructivoService;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/funcionarioInstructivo")
public class FuncionarioInstructivoController {

  private final FuncionarioInstructivoService funcionarioInstructivoService;

  @GetMapping
  public ResponseEntity<List<FuncionarioInstructivo>> getAll() {
    List<FuncionarioInstructivo> funcionarioInstructivos = funcionarioInstructivoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioInstructivos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FuncionarioInstructivo> getById(@PathVariable Integer id) {
    FuncionarioInstructivo funcionarioInstructivoFound = funcionarioInstructivoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioInstructivoFound);
  }

  @PostMapping
  public ResponseEntity<FuncionarioInstructivo> create(@RequestBody FuncionarioInstructivoDto funcionarioInstructivoDto) {
    FuncionarioInstructivo funcionarioInstructivoSaved = funcionarioInstructivoService.create(funcionarioInstructivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioInstructivoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<FuncionarioInstructivo> update(@PathVariable Integer id, @RequestBody FuncionarioInstructivoDto funcionarioInstructivoDto) {
    FuncionarioInstructivo funcionarioInstructivoUpdated = funcionarioInstructivoService.update(id, funcionarioInstructivoDto);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioInstructivoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    funcionarioInstructivoService.delete(id);
    return ResponseEntity.ok().build();
  }

}