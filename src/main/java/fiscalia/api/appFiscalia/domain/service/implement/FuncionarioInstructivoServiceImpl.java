package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.*;
import fiscalia.api.appFiscalia.domain.entity.*;
import fiscalia.api.appFiscalia.domain.mapper.FuncionarioInstructivoMapper;
import fiscalia.api.appFiscalia.domain.mapper.FuncionarioMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioInstructivoService;
import fiscalia.api.appFiscalia.domain.service.interfaces.FuncionarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioInstructivoServiceImpl implements FuncionarioInstructivoService {

  private final FuncionarioInstructivoRepository funcionarioInstructivoRepository;
  private final FuncionarioRepository funcionarioRepository;
  private final InstructivoRepository instructivoRepository;
  private final FuncionarioInstructivoMapper funcionarioInstructivoMapper;

  @Override
  public List<FuncionarioInstructivo> getAll() {
    return funcionarioInstructivoRepository.findAllByActivo(true);
  }

  @Override
  public FuncionarioInstructivo getById(Integer id) {
    FuncionarioInstructivo funcionarioInstructivo = funcionarioInstructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FuncionarioInstructivo", id));
    return funcionarioInstructivo;
  }

  @Override
  public FuncionarioInstructivo create(FuncionarioInstructivoDto funcionarioInstructivoDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(funcionarioInstructivoDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para FuncionarioInstructivo", funcionarioInstructivoDto.getIdFuncionario().getId()));
    funcionarioInstructivoDto.setIdFuncionario(funcionarioFound);
    Instructivo instructivoFound = instructivoRepository.findById(funcionarioInstructivoDto.getIdInstructivo().getId()).orElseThrow(() -> new EntityNotFoundException("Instructivo para FuncionarioInstructivo", funcionarioInstructivoDto.getIdInstructivo().getId()));
    funcionarioInstructivoDto.setIdInstructivo(instructivoFound);
    FuncionarioInstructivo funcionarioInstructivo = funcionarioInstructivoMapper.fromDto(funcionarioInstructivoDto, null);
    return funcionarioInstructivoRepository.save(funcionarioInstructivo);
  }

  @Override
  public FuncionarioInstructivo update(Integer id, FuncionarioInstructivoDto funcionarioInstructivoDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(funcionarioInstructivoDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para FuncionarioInstructivo", funcionarioInstructivoDto.getIdFuncionario().getId()));
    funcionarioInstructivoDto.setIdFuncionario(funcionarioFound);
    Instructivo instructivoFound = instructivoRepository.findById(funcionarioInstructivoDto.getIdInstructivo().getId()).orElseThrow(() -> new EntityNotFoundException("Instructivo para FuncionarioInstructivo", funcionarioInstructivoDto.getIdInstructivo().getId()));
    funcionarioInstructivoDto.setIdInstructivo(instructivoFound);
    FuncionarioInstructivo funcionarioInstructivoFound = funcionarioInstructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FuncionarioInstructivo", id));
    FuncionarioInstructivo funcionarioInstructivo = funcionarioInstructivoMapper.fromDto(funcionarioInstructivoDto, funcionarioInstructivoFound);
    return funcionarioInstructivoRepository.save(funcionarioInstructivo);
  }

  @Override
  public void delete(Integer id) {
    FuncionarioInstructivo funcionarioInstructivoFound = funcionarioInstructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FuncionarioInstructivo", id));
    funcionarioInstructivoFound.setActivo(false);
    funcionarioInstructivoFound.setFecha_eliminacion(LocalDateTime.now());
    funcionarioInstructivoRepository.save(funcionarioInstructivoFound);
  }

}
