package et.clicket.api.appClicket.presentation.controller;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Usuario;
import et.clicket.api.appClicket.domain.service.interfaces.FuncionarioService;
import et.clicket.api.appClicket.domain.service.interfaces.UsuarioService;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

  private final UsuarioService usuarioService;

  @GetMapping
  public ResponseEntity<List<Usuario>> getAll() {
    List<Usuario> usuarios = usuarioService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(usuarios);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
    Usuario usuarioFound = usuarioService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioFound);
  }

  @PostMapping
  public ResponseEntity<Usuario> create(@RequestBody UsuarioDto usuarioDto) {
    Usuario usuarioSaved = usuarioService.create(usuarioDto);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
    Usuario usuarioUpdated = usuarioService.update(id, usuarioDto);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    usuarioService.delete(id);
    return ResponseEntity.ok().build();
  }

}