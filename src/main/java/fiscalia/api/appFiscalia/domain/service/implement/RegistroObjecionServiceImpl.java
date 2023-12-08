package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.*;
import fiscalia.api.appFiscalia.domain.entity.*;
import fiscalia.api.appFiscalia.domain.mapper.RegistroObjecionMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.RegistroObjecionService;
import fiscalia.api.appFiscalia.presentation.request.dto.RegistroObjecionDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistroObjecionServiceImpl implements RegistroObjecionService {

  private final RegistroObjecionRepository registroObjecionRepository;
  private final TipoObjecionRepository tipoObjecionRepository;
  private final FuncionarioRepository funcionarioRepository;

  private final RegistroObjecionMapper registroObjecionMapper;

  @Override
  public List<RegistroObjecion> getAll() {return registroObjecionRepository.findAllByActivo(true);
  }

  @Override
  public RegistroObjecion getById(Integer id) {
    RegistroObjecion registroObjecion = registroObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RegistroObjecion", id));
    return registroObjecion;
  }

  @Override
  public RegistroObjecion create(RegistroObjecionDto registroObjecionDto) {
    TipoObjecion tipoObjecionFound = tipoObjecionRepository.findById(registroObjecionDto.getIdTipoObjecion().getId()).orElseThrow(() -> new EntityNotFoundException("TipoObjecion para RegistroObjecion", registroObjecionDto.getIdTipoObjecion().getId()));
    registroObjecionDto.setIdTipoObjecion(tipoObjecionFound);
    Funcionario funcionarioFound = funcionarioRepository.findById(registroObjecionDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para RegistroObjecion", registroObjecionDto.getIdFuncionario().getId()));
    registroObjecionDto.setIdFuncionario(funcionarioFound);
    RegistroObjecion registroObjecion = registroObjecionMapper.fromDto(registroObjecionDto, null);
    return registroObjecionRepository.save(registroObjecion);
  }

  @Override
  public RegistroObjecion update(Integer id, RegistroObjecionDto registroObjecionDto) {
    TipoObjecion tipoObjecionFound = tipoObjecionRepository.findById(registroObjecionDto.getIdTipoObjecion().getId()).orElseThrow(() -> new EntityNotFoundException("TipoObjecion para RegistroObjecion", registroObjecionDto.getIdTipoObjecion().getId()));
    registroObjecionDto.setIdTipoObjecion(tipoObjecionFound);
    Funcionario funcionarioFound = funcionarioRepository.findById(registroObjecionDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para RegistroObjecion", registroObjecionDto.getIdFuncionario().getId()));
    registroObjecionDto.setIdFuncionario(funcionarioFound);
    RegistroObjecion registroObjecionFound = registroObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro Objecion", id));
    RegistroObjecion registroObjecion = registroObjecionMapper.fromDto(registroObjecionDto, registroObjecionFound);
    return registroObjecionRepository.save(registroObjecion);
  }

  @Override
  public void delete(Integer id) {
    RegistroObjecion registroObjecionFound = registroObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Resgistro Objecion", id));
    registroObjecionFound.setActivo(false);
    registroObjecionFound.setFecha_eliminacion(LocalDateTime.now());
    registroObjecionRepository.save(registroObjecionFound);
  }

}
