package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.presentation.request.dto.PersonaDto;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

  public Persona fromDto(PersonaDto personaDto, Persona personaFound) {
    Persona persona = new Persona();

    if(personaFound != null){
      persona = personaFound;
    }

    persona.setNombre(personaDto.getNombre());
    persona.setApellidoPat(personaDto.getApellidoPat());
    persona.setApellidoMat(personaDto.getApellidoMat());
    persona.setCi(personaDto.getCi());
    persona.setCelular(personaDto.getCelular());

    return persona;
  }

}
