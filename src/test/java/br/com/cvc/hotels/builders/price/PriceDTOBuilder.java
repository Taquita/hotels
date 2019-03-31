package br.com.cvc.hotels.builders.price;

import br.com.cvc.hotels.models.price.PriceDTO;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see PriceDTO
 *
 * Class Builder for PriceDTO
 */
public class PriceDTOBuilder {

    private PriceDTO price;

    private PriceDTOBuilder() {}

    public static PriceDTOBuilder onePrice() {
        PriceDTOBuilder builder = new PriceDTOBuilder();
        builder.price = new PriceDTO();
        builder.price.setAdult(100.00);
        builder.price.setChild(100.00);
        return builder;
    }

    public PriceDTO now() {
        return this.price;
    }

}
