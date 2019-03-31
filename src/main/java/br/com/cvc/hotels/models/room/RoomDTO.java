package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.models.price.PriceDTO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO extends RoomCommon{
    private PriceDTO price;
}
