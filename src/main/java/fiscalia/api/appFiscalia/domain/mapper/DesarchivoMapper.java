package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Desarchivo;
import fiscalia.api.appFiscalia.presentation.request.dto.DesarchivoDto;
import org.springframework.stereotype.Component;

@Component
public class DesarchivoMapper {

  public Desarchivo fromDto(DesarchivoDto desarchivoDto, Desarchivo desarchivoFound) {
    Desarchivo desarchivo = new Desarchivo();

    if(desarchivoFound != null){
      desarchivo = desarchivoFound;
    }

    desarchivo.setCud(desarchivoDto.getCud());
    desarchivo.setMotivo(desarchivoDto.getMotivo());
    desarchivo.setIdFuncionario(desarchivoDto.getIdFuncionario());
    desarchivo.setIdDelito(desarchivoDto.getIdDelito());

    return desarchivo;
  }

}
