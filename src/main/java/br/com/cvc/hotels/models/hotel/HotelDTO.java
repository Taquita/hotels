package br.com.cvc.hotels.models.hotel;

import br.com.cvc.hotels.models.room.RoomDTO;
import lombok.*;

import java.util.List;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Hotel with properties for Broken return
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO extends HotelCommon {

    private List<RoomDTO> rooms;

}
