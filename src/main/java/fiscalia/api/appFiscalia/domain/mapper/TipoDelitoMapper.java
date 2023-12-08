package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoDelitoDto;
import org.springframework.stereotype.Component;

@Component
public class TipoDelitoMapper {

    public TipoDelito fromDto(TipoDelitoDto tipoDelitoDto, TipoDelito tipoDelitoFound) {
        TipoDelito tipoDelito = new TipoDelito();

        if(tipoDelitoFound != null){
            tipoDelito = tipoDelitoFound;
        }

        tipoDelito.setDescripcion(tipoDelitoDto.getDescripcion());

        return tipoDelito;
    }

}
