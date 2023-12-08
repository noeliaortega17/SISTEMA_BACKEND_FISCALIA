package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.RegistroObjecion;
import fiscalia.api.appFiscalia.presentation.request.dto.RegistroObjecionDto;
import org.springframework.stereotype.Component;

@Component
public class RegistroObjecionMapper {

  public RegistroObjecion fromDto(RegistroObjecionDto registroObjecionDto, RegistroObjecion registroObjecionFound) {
    RegistroObjecion registroObjecion = new RegistroObjecion();

    if(registroObjecionFound != null){
      registroObjecion = registroObjecionFound;
    }
    registroObjecion.setNumeroResolucion(registroObjecionDto.getNumeroResolucion());
    registroObjecion.setCud(registroObjecionDto.getCud());
    registroObjecion.setIdTipoObjecion(registroObjecionDto.getIdTipoObjecion());
    registroObjecion.setIdFuncionario(registroObjecionDto.getIdFuncionario());


    return registroObjecion;
  }

}
