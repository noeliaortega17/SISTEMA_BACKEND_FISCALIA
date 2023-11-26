package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UnidadDto;
import org.springframework.stereotype.Component;

@Component
public class UnidadMapper {

  public Unidad fromDto(UnidadDto unidadDto, Unidad unidadFound) {
    Unidad unidad = new Unidad();

    if(unidadFound != null){
      unidad = unidadFound;
    }

    unidad.setDescripcion(unidadDto.getDescripcion());

    return unidad;
  }

}
