package br.com.cvc.hotels.models.price;

import lombok.*;
import org.decimal4j.util.DoubleRounder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PriceReturnDTO extends PriceCommon{

    private Double pricePerDayAdult;
    private Double pricePerDayChild;

    public void setPricePerDayAdult(Double pricePerDayAdult) {
        this.pricePerDayAdult = DoubleRounder.round(pricePerDayAdult / 0.7, 2);
    }

    public void setPricePerDayChild(Double pricePerDayChild) {
        this.pricePerDayChild = DoubleRounder.round(pricePerDayChild / 0.7, 2);
    }
}
