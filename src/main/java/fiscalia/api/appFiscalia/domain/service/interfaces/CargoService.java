package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Cargo;
import fiscalia.api.appFiscalia.presentation.request.dto.CargoDto;
import java.util.List;

public interface CargoService {

  List<Cargo> getAll();
  Cargo getById(Integer id);
  Cargo create(CargoDto cargo);
  Cargo update(Integer id, CargoDto cargo);
  void delete(Integer id);

}
