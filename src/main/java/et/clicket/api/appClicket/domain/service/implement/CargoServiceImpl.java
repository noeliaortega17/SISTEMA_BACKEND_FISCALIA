package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.CargoRepository;
import et.clicket.api.appClicket.data.FuncionarioRepository;
import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.mapper.CargoMapper;
import et.clicket.api.appClicket.domain.service.interfaces.CargoService;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import et.clicket.api.exception.EntityNotFoundException;
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
    cargoRepository.save(cargoFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
