package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.models.price.PriceDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class RoomCommon {

    private Long roomID;
    private String categoryName;

}
