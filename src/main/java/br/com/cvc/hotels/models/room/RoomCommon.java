package br.com.cvc.hotels.models.room;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Room with common properties
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class RoomCommon {

    private Long roomID;
    private String categoryName;

}
