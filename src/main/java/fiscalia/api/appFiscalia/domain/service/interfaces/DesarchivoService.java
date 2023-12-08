package fiscalia.api.appFiscalia.domain.service.interfaces;


import fiscalia.api.appFiscalia.domain.entity.Desarchivo;
import fiscalia.api.appFiscalia.presentation.request.dto.DesarchivoDto;


import java.util.List;

public interface DesarchivoService {

  List<Desarchivo> getAll();
  Desarchivo getById(Integer id);
  Desarchivo create(DesarchivoDto desarchivo);
  Desarchivo update(Integer id, DesarchivoDto desarchivo);
  void delete(Integer id);

}
