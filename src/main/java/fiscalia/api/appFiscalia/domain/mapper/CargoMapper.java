package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Cargo;
import fiscalia.api.appFiscalia.presentation.request.dto.CargoDto;
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
