package br.com.cvc.hotels.mappers;

import br.com.cvc.hotels.models.room.RoomDTO;
import br.com.cvc.hotels.models.room.RoomReturnDTO;
import org.modelmapper.ModelMapper;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for create mapping for conversion between room objects;
 */
public class RoomMapper {

    public static void convertMapper(ModelMapper mapper) {
        if (mapper.getTypeMap(RoomDTO.class, RoomReturnDTO.class) == null)
            mapper.createTypeMap(RoomDTO.class, RoomReturnDTO.class)
                    .addMappings(propertyMap -> propertyMap.map(RoomDTO::getPrice, RoomReturnDTO::setPriceDetail));
    }

}
