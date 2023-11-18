package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import java.util.List;

public interface CargoService {

  List<Cargo> getAll();
  Cargo getById(Integer id);
  Cargo create(CargoDto cargo);
  Cargo update(Integer id, CargoDto cargo);
  void delete(Integer id);

}
