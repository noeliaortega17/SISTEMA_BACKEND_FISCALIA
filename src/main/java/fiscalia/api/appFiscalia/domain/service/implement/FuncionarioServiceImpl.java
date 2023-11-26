package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.CargoRepository;
import fiscalia.api.appFiscalia.data.FuncionarioRepository;
import fiscalia.api.appFiscalia.data.PersonaRepository;
import fiscalia.api.appFiscalia.data.UnidadRepository;
import fiscalia.api.appFiscalia.domain.entity.Cargo;
import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.Persona;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import fiscalia.api.appFiscalia.domain.mapper.FuncionarioMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import fiscalia.api.exception.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

  private final FuncionarioRepository funcionarioRepository;
  private final PersonaRepository personaRepository;
  private final CargoRepository cargoRepository;
  private final UnidadRepository unidadRepository;
  private final FuncionarioMapper funcionarioMapper;

  @Override
  public List<Funcionario> getAll() {
    return funcionarioRepository.findAllByActivo(true);
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
    Unidad unidadFound = unidadRepository.findById(funcionarioDto.getIdUnidad().getId()).orElseThrow(() -> new EntityNotFoundException("Unidad para funcionario", funcionarioDto.getIdUnidad().getId()));
    funcionarioDto.setIdUnidad(unidadFound);
    Funcionario funcionario = funcionarioMapper.fromDto(funcionarioDto, null);
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public Funcionario update(Integer id, FuncionarioDto funcionarioDto) {
    Persona personaFound = personaRepository.findById(funcionarioDto.getIdPersona().getId()).orElseThrow(() -> new EntityNotFoundException("Persona para funcionario", funcionarioDto.getIdPersona().getId()));
    funcionarioDto.setIdPersona(personaFound);
    Cargo cargoFound = cargoRepository.findById(funcionarioDto.getIdCargo().getId()).orElseThrow(() -> new EntityNotFoundException("Cargo para funcionario", funcionarioDto.getIdCargo().getId()));
    funcionarioDto.setIdCargo(cargoFound);
    Unidad unidadFound = unidadRepository.findById(funcionarioDto.getIdUnidad().getId()).orElseThrow(() -> new EntityNotFoundException("Unidad para funcionario", funcionarioDto.getIdUnidad().getId()));
    funcionarioDto.setIdUnidad(unidadFound);
    Funcionario funcionarioFound = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario", id));
    Funcionario funcionario = funcionarioMapper.fromDto(funcionarioDto, funcionarioFound);
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public void delete(Integer id) {
    Funcionario funcionarioFound = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario", id));
    funcionarioFound.setActivo(false);
    funcionarioFound.setFecha_eliminacion(LocalDateTime.now());
    funcionarioRepository.save(funcionarioFound);
  }

}
