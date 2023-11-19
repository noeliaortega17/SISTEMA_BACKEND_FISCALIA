package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.service.interfaces.PerfilService;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/perfil")
public class PerfilController {

  private final PerfilService perfilService;

  @GetMapping
  public ResponseEntity<List<Perfil>> getAll() {
    List<Perfil> perfiles = perfilService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(perfiles);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Perfil> getById(@PathVariable Integer id) {
    Perfil perfilFound = perfilService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(perfilFound);
  }

  @PostMapping
  public ResponseEntity<Perfil> create(@RequestBody PerfilDto perfilDto) {
    Perfil perfilSaved = perfilService.create(perfilDto);
    return ResponseEntity.status(HttpStatus.OK).body(perfilSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Perfil> update(@PathVariable Integer id, @RequestBody PerfilDto perfilDto) {
    Perfil perfilUpdated = perfilService.update(id, perfilDto);
    return ResponseEntity.status(HttpStatus.OK).body(perfilUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    perfilService.delete(id);
    return ResponseEntity.ok().build();
  }

}