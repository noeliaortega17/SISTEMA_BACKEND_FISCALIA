package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.CargoRepository;
import fiscalia.api.appFiscalia.domain.entity.Cargo;
import fiscalia.api.appFiscalia.domain.mapper.CargoMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.CargoService;
import fiscalia.api.appFiscalia.presentation.request.dto.CargoDto;
import fiscalia.api.exception.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {

  private final CargoRepository cargoRepository;
  private final CargoMapper cargoMapper;

  @Override
  public List<Cargo> getAll() {
    return cargoRepository.findAllByActivo(true);
  }

  @Override
  public Cargo getById(Integer id) {
    Cargo cargo = cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo", id));
    return cargo;
  }

  @Override
  public Cargo create(CargoDto cargoDto) {
    Cargo cargo = cargoMapper.fromDto(cargoDto, null);
    return cargoRepository.save(cargo);
  }

  @Override
  public Cargo update(Integer id, CargoDto cargoDto) {
    Cargo cargoFound = cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo", id));
    Cargo cargo = cargoMapper.fromDto(cargoDto, cargoFound);
    return cargoRepository.save(cargo);
  }

  @Override
  public void delete(Integer id) {
    Cargo cargoFound = cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo", id));
    cargoFound.setActivo(false);
    cargoFound.setFecha_eliminacion(LocalDateTime.now());
    cargoRepository.save(cargoFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
