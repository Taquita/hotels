package br.com.cvc.hotels.builders.price;

import br.com.cvc.hotels.models.price.PriceReturnDTO;

public class PriceReturnDTOBuilder {

    private PriceReturnDTO price;

    private PriceReturnDTOBuilder() {}

    public static PriceReturnDTOBuilder onePrice() {
        PriceReturnDTOBuilder builder = new PriceReturnDTOBuilder();
        builder.price = new PriceReturnDTO();
        builder.price.setPricePerDayAdult(100.00);
        builder.price.setPricePerDayChild(50.00);
        return builder;
    }

    public PriceReturnDTO now() {
        return this.price;
    }
}
