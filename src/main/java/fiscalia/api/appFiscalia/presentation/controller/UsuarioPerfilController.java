package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import fiscalia.api.appFiscalia.domain.service.interfaces.UsuarioPerfilService;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioPerfilDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/usuarioperfil")
public class UsuarioPerfilController {

  private final UsuarioPerfilService usuarioPerfilService;

  @GetMapping
  public ResponseEntity<List<UsuarioPerfil>> getAll() {
    List<UsuarioPerfil> usuariosPerfiles = usuarioPerfilService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(usuariosPerfiles);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioPerfil> getById(@PathVariable Integer id) {
    UsuarioPerfil usuarioPerfilFound = usuarioPerfilService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioPerfilFound);
  }

  @PostMapping
  public ResponseEntity<UsuarioPerfil> create(@RequestBody UsuarioPerfilDto usuarioPerfilDto) {
    UsuarioPerfil usuarioPerfilSaved = usuarioPerfilService.create(usuarioPerfilDto);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioPerfilSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<UsuarioPerfil> update(@PathVariable Integer id, @RequestBody UsuarioPerfilDto usuarioPerfilDto) {
    UsuarioPerfil usuarioPerfilUpdated = usuarioPerfilService.update(id, usuarioPerfilDto);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioPerfilUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    usuarioPerfilService.delete(id);
    return ResponseEntity.ok().build();
  }

}