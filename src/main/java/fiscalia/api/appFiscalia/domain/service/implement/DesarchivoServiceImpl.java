package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.*;
import fiscalia.api.appFiscalia.domain.entity.*;
import fiscalia.api.appFiscalia.domain.mapper.DesarchivoMapper;
import fiscalia.api.appFiscalia.domain.mapper.FuncionarioInstructivoMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.DesarchivoService;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioInstructivoService;
import fiscalia.api.appFiscalia.presentation.request.dto.DesarchivoDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DesarchivoServiceImpl implements DesarchivoService {

  private final DesarchivoRepository desarchivoRepository;
  private final FuncionarioRepository funcionarioRepository;
  private final DelitoRepository delitoRepository;
  private final DesarchivoMapper desarchivoMapper;

  @Override
  public List<Desarchivo> getAll() {
    return desarchivoRepository.findAllByActivo(true);
  }

  @Override
  public Desarchivo getById(Integer id) {
    Desarchivo desarchivo = desarchivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Desarchivo", id));
    return desarchivo;
  }

  @Override
  public Desarchivo create(DesarchivoDto desarchivoDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(desarchivoDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para Desarchivo", desarchivoDto.getIdFuncionario().getId()));
    desarchivoDto.setIdFuncionario(funcionarioFound);
    Delito delitoFound = delitoRepository.findById(desarchivoDto.getIdDelito().getId()).orElseThrow(() -> new EntityNotFoundException("Delito para Desarchivo", desarchivoDto.getIdDelito().getId()));
    desarchivoDto.setIdDelito(delitoFound);
    Desarchivo desarchivo = desarchivoMapper.fromDto(desarchivoDto, null);
    return desarchivoRepository.save(desarchivo);
  }

  @Override
  public Desarchivo update(Integer id, DesarchivoDto desarchivoDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(desarchivoDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para Desarchivo", desarchivoDto.getIdFuncionario().getId()));
    desarchivoDto.setIdFuncionario(funcionarioFound);
    Delito delitoFound = delitoRepository.findById(desarchivoDto.getIdDelito().getId()).orElseThrow(() -> new EntityNotFoundException("Delito para Desarchivo", desarchivoDto.getIdDelito().getId()));
    desarchivoDto.setIdDelito(delitoFound);
    Desarchivo desarchivoFound = desarchivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Desarchivo", id));
    Desarchivo desarchivo = desarchivoMapper.fromDto(desarchivoDto, desarchivoFound);
    return desarchivoRepository.save(desarchivo);
  }

  @Override
  public void delete(Integer id) {
    Desarchivo desarchivoFound = desarchivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Desarchivo", id));
    desarchivoFound.setActivo(false);
    desarchivoFound.setFecha_eliminacion(LocalDateTime.now());
    desarchivoRepository.save(desarchivoFound);
  }

}
