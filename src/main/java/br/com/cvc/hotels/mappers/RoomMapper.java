package br.com.cvc.hotels.mappers;

import br.com.cvc.hotels.models.room.RoomDTO;
import br.com.cvc.hotels.models.room.RoomReturnDTO;
import org.modelmapper.ModelMapper;

public class RoomMapper {

    public static void convertMapper(ModelMapper mapper) {
        if (mapper.getTypeMap(RoomDTO.class, RoomReturnDTO.class) == null)
            mapper.createTypeMap(RoomDTO.class, RoomReturnDTO.class)
                    .addMappings(propertyMap -> propertyMap.map(RoomDTO::getPrice, RoomReturnDTO::setPriceDetail));
    }

}
