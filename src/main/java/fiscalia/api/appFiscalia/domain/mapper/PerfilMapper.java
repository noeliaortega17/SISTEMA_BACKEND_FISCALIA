package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

  public Perfil fromDto(PerfilDto perfilDto, Perfil perfilFound) {
    Perfil perfil = new Perfil();

    if(perfilFound != null){
      perfil = perfilFound;
    }

    perfil.setDescripcion(perfilDto.getDescripcion());

    return perfil;
  }

}
