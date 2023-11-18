package et.clicket.api.appClicket.presentation.controller;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.service.interfaces.CargoService;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
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
@RequestMapping("/cargo")
public class CargoController {

  private final CargoService cargoService;

  @GetMapping
  public ResponseEntity<List<Cargo>> getAll() {
    List<Cargo> cargos = cargoService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(cargos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cargo> getById(@PathVariable Integer id) {
    Cargo cargoFound = cargoService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(cargoFound);
  }

  @PostMapping
  public ResponseEntity<Cargo> create(@RequestBody CargoDto cargoDto) {
    Cargo cargoSaved = cargoService.create(cargoDto);
    return ResponseEntity.status(HttpStatus.OK).body(cargoSaved);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Cargo> update(@PathVariable Integer id, @RequestBody CargoDto cargoDto) {
    Cargo cargoUpdated = cargoService.update(id, cargoDto);
    return ResponseEntity.status(HttpStatus.OK).body(cargoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    cargoService.delete(id);
    return ResponseEntity.ok().build();
  }

}