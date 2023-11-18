package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Perfil;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import et.clicket.api.appClicket.presentation.request.dto.PerfilDto;
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
