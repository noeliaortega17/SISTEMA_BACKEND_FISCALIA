package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import fiscalia.api.appFiscalia.presentation.request.dto.InstructivoDto;
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
    instructivo.setFiscaliaGeneral(instructivoDto.getFiscaliaGeneral());
    instructivo.setFechaInstructivo(instructivoDto.getFechaInstructivo());

    return instructivo;
  }

}
