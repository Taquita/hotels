package br.com.cvc.hotels.models.hotel;

import br.com.cvc.hotels.models.room.RoomReturnDTO;
import lombok.*;

import java.util.List;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Hotel return object for client
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class HotelReturnDTO extends HotelCommon {

    private List<RoomReturnDTO> rooms;

}
