package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Delito;
import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import fiscalia.api.appFiscalia.presentation.request.dto.DelitoDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import org.springframework.stereotype.Component;

@Component
public class DelitoMapper {

  public Delito fromDto(DelitoDto delitoDto, Delito delitoFound) {
    Delito delito = new Delito();

    if(delitoFound != null){
      delito = delitoFound;
    }

    delito.setDescripcion(delitoDto.getDescripcion());
    delito.setIdTipoDelito(delitoDto.getIdTipoDelito());

    return delito;
  }

}
