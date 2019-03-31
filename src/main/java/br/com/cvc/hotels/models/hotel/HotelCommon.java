package br.com.cvc.hotels.models.hotel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Hotel with common properties
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class HotelCommon {

    private Long id;
    private String name;
    private Long cityCode;
    private String cityName;

}
