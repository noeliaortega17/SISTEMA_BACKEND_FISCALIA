package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.CargoRepository;
import et.clicket.api.appClicket.data.FuncionarioRepository;
import et.clicket.api.appClicket.data.PersonaRepository;
import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.domain.mapper.FuncionarioMapper;
import et.clicket.api.appClicket.domain.service.interfaces.FuncionarioService;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.exception.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

  private final FuncionarioRepository funcionarioRepository;
  private final PersonaRepository personaRepository;
  private final CargoRepository cargoRepository;
  private final FuncionarioMapper funcionarioMapper;

  @Override
  public List<Funcionario> getAll() {
    return funcionarioRepository.findAll();
  }

  @Override
  public Funcionario getById(Integer id) {
    Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario", id));
    return funcionario;
  }

  @Override
  public Funcionario create(FuncionarioDto funcionarioDto) {
    Persona personaFound = personaRepository.findById(funcionarioDto.getIdPersona().getId()).orElseThrow(() -> new EntityNotFoundException("Persona para funcionario", funcionarioDto.getIdPersona().getId()));
    funcionarioDto.setIdPersona(personaFound);
    Cargo cargoFound = cargoRepository.findById(funcionarioDto.getIdCargo().getId()).orElseThrow(() -> new EntityNotFoundException("Cargo para funcionario", funcionarioDto.getIdCargo().getId()));
    funcionarioDto.setIdCargo(cargoFound);
    Funcionario funcionario = funcionarioMapper.fromDto(funcionarioDto, null);
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public Funcionario update(Integer id, FuncionarioDto funcionarioDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario", id));
    Funcionario funcionario = funcionarioMapper.fromDto(funcionarioDto, funcionarioFound);
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public void delete(Integer id) {
    Funcionario funcionarioFound = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario", id));
    funcionarioFound.setActivo(false);
    funcionarioRepository.save(funcionarioFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
