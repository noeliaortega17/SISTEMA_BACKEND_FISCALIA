package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

  private final FuncionarioService funcionarioService;

  @GetMapping
  public ResponseEntity<List<Funcionario>> getAll() {
    List<Funcionario> funcionarios = funcionarioService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Funcionario> getById(@PathVariable Integer id) {
    Funcionario funcionarioFound = funcionarioService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioFound);
  }

  @PostMapping
  public ResponseEntity<Funcionario> create(@RequestBody FuncionarioDto funcionarioDto) {
    Funcionario funcionarioSaved = funcionarioService.create(funcionarioDto);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody FuncionarioDto funcionarioDto) {
    Funcionario funcionarioUpdated = funcionarioService.update(id, funcionarioDto);
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    funcionarioService.delete(id);
    return ResponseEntity.ok().build();
  }

}