package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.models.price.PriceDTO;
import lombok.*;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Room with properties for Broken return
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO extends RoomCommon{
    private PriceDTO price;
}
