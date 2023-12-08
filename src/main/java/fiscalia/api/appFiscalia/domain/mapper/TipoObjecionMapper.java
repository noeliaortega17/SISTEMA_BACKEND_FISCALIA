package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoObjecionDto;
import org.springframework.stereotype.Component;

@Component
public class TipoObjecionMapper {

  public TipoObjecion fromDto(TipoObjecionDto tipoObjecionDto, TipoObjecion tipoObjecionFound) {
    TipoObjecion tipoObjecion = new TipoObjecion();

    if(tipoObjecionFound != null){
      tipoObjecion = tipoObjecionFound;
    }

    tipoObjecion.setDescripcion(tipoObjecionDto.getDescripcion());

    return tipoObjecion;
  }

}
