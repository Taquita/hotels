package br.com.cvc.hotels.models.price;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class PriceCommon {

    private BigDecimal adult;
    private BigDecimal child;

}
