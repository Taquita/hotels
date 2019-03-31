package br.com.cvc.hotels.models.price;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Price with common properties
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class PriceCommon implements Serializable {
}
