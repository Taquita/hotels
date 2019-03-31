package br.com.cvc.hotels.mappers;

import br.com.cvc.hotels.models.price.PriceDTO;
import br.com.cvc.hotels.models.price.PriceReturnDTO;
import org.modelmapper.ModelMapper;

public class PriceMapper {

    public static void convertMapper(ModelMapper mapper) {
        if (mapper.getTypeMap(PriceDTO.class, PriceReturnDTO.class) == null)
            mapper.createTypeMap(PriceDTO.class, PriceReturnDTO.class)
                    .addMappings(propertyMap -> {
                        propertyMap.map(PriceDTO::getAdult, PriceReturnDTO::setPricePerDayAdult);
                        propertyMap.map(PriceDTO::getChild, PriceReturnDTO::setPricePerDayChild);
                    });
    }

}
