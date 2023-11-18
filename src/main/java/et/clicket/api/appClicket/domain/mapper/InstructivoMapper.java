package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Instructivo;
import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.presentation.request.dto.InstructivoDto;
import et.clicket.api.appClicket.presentation.request.dto.PersonaDto;
import org.springframework.stereotype.Component;

@Component
public class InstructivoMapper {

  public Instructivo fromDto(InstructivoDto instructivoDto, Instructivo instructivoFound) {
    Instructivo instructivo = new Instructivo();

    if(instructivoFound != null){
      instructivo = instructivoFound;
    }

    instructivo.setCite(instructivoDto.getCite());
    instructivo.setDescripcion(instructivoDto.getDescripcion());
    instructivo.setFiscalia_general(instructivoDto.getFiscaliaGeneral());
    instructivo.setFecha_instructivo(instructivoDto.getFecha_instructivo());

    return instructivo;
  }

}
