package fiscalia.api.appFiscalia.presentation.controller;

import fiscalia.api.appFiscalia.domain.entity.Persona;
import fiscalia.api.appFiscalia.domain.service.interfaces.PersonaService;
import fiscalia.api.appFiscalia.presentation.request.dto.PersonaDto;
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
@RequestMapping("/persona")
public class PersonaController {

  private final PersonaService personaService;

  @GetMapping
  public ResponseEntity<List<Persona>> getAll() {
    List<Persona> personas = personaService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(personas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Persona> getById(@PathVariable Integer id) {
    Persona personaFound = personaService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(personaFound);
  }

  @PostMapping
  public ResponseEntity<Persona> create(@RequestBody PersonaDto personaDto) {
    Persona personaSaved = personaService.create(personaDto);
    return ResponseEntity.status(HttpStatus.OK).body(personaSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Persona> update(@PathVariable Integer id, @RequestBody PersonaDto personaDto) {
    Persona personaUpdated = personaService.update(id, personaDto);
    return ResponseEntity.status(HttpStatus.OK).body(personaUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    personaService.delete(id);
    return ResponseEntity.ok().build();
  }

}