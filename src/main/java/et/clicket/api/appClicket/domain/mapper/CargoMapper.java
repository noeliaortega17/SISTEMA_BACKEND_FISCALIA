package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import org.springframework.stereotype.Component;

@Component
public class CargoMapper {

  public Cargo fromDto(CargoDto cargoDto, Cargo cargoFound) {
    Cargo cargo = new Cargo();

    if(cargoFound != null){
      cargo = cargoFound;
    }

    cargo.setDescripcion(cargoDto.getDescripcion());
    cargo.setItem(cargoDto.getItem());

    return cargo;
  }

}
