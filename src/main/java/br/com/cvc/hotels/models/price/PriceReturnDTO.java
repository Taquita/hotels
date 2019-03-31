package br.com.cvc.hotels.models.price;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.decimal4j.util.DoubleRounder;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Price return object for client
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PriceReturnDTO extends PriceCommon{

    private Double pricePerDayAdult;
    private Double pricePerDayChild;

    /**
     * Set value stay with commission
     *
     * @param pricePerDayAdult - original value stay per adult in hotel
     */
    public void setPricePerDayAdult(Double pricePerDayAdult) {
        this.pricePerDayAdult = DoubleRounder.round(pricePerDayAdult / 0.7, 2);
    }

    /**
     * Set value stay with commission
     *
     * @param pricePerDayChild - original value stay per child in hotel
     */
    public void setPricePerDayChild(Double pricePerDayChild) {
        this.pricePerDayChild = DoubleRounder.round(pricePerDayChild / 0.7, 2);
    }
}
