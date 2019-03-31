package br.com.cvc.hotels.models.price;

import lombok.*;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Price with properties for Broken return
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends PriceCommon {

    private Double adult;
    private Double child;

}
